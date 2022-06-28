package com.rainbow.mall.goods.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rainbow.mall.common.core.utils.SnowFlakeUtil;
import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.goods.service.adapt.GoodsSearchAdapt;
import com.rainbow.mall.goods.service.adapt.dto.GoodsSkuSearchAdaptDTO;
import com.rainbow.mall.goods.service.adapt.dto.GoodsSkuSearchAdaptParamDTO;
import com.rainbow.mall.goods.service.convert.GoodsConvert;
import com.rainbow.mall.goods.service.enums.GoodsAuthEnum;
import com.rainbow.mall.goods.service.enums.GoodsStatusEnum;
import com.rainbow.mall.goods.service.enums.GoodsTypeEnum;
import com.rainbow.mall.goods.service.enums.ResultCode;
import com.rainbow.mall.goods.service.exception.GoodsServiceException;
import com.rainbow.mall.goods.service.pojo.dto.base.CategoryBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.GoodsCreateDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QueryGoodsSkuListDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.WholesaleDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.goods.GoodsDetailBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.goods.GoodsSkuDetailDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuSpecDTO;
import com.rainbow.mall.goods.service.repository.GoodsRepository;
import com.rainbow.mall.goods.service.service.CategoryService;
import com.rainbow.mall.goods.service.service.GoodsGalleryService;
import com.rainbow.mall.goods.service.service.GoodsService;
import com.rainbow.mall.goods.service.service.GoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GoodsServiceImpl  implements GoodsService {

   @Autowired
   private GoodsConvert goodsConvert;

   @Autowired
   private GoodsRepository goodsRepository;

   @Autowired
   private GoodsSkuService goodsSkuService;

   @Autowired
   private TransactionTemplate transactionTemplate;

   @Autowired
   private GoodsSearchAdapt goodsSearchAdapt;

   @Autowired
   private GoodsGalleryService goodsGalleryService;

   @Autowired
   private CategoryService categoryService;

   @Autowired
   private ThreadPoolTaskExecutor executor;

    @Override
    public void createGoods(GoodsCreateDTO goodsCreateDTO) {
      //1.构建数据
      GoodsBaseDTO goodsBaseDTO = buildInsertGoods(goodsCreateDTO);
      //2.参数校验
      checkGoods(goodsBaseDTO);
      Boolean execute = transactionTemplate.execute(transactionStatus -> {
        try {
            //3.保存spu
            GoodsBaseDTO insertGoodsBaseDTO = goodsRepository.insertGoods(goodsBaseDTO);
            //4.保存sku
            createGoodsSku(insertGoodsBaseDTO, goodsCreateDTO.getSkuList());
            return true;
        } catch (Exception e) {
            log.error("新增商品异常", e);
            transactionStatus.setRollbackOnly();
        }
        return false;
     });
     if(Objects.equals(Boolean.FALSE,execute)){
          throw new GoodsServiceException(ResultCode.GOODS_ERROR.message());
     }
    }

    @Override
    public Page<List<QuerySkuListGoodsBaseDTO>> querySkuList(QueryGoodsSkuListDTO dto) {
        GoodsSkuSearchAdaptParamDTO paramDTO =  goodsConvert.convertToGoodsSkuSearchAdaptParamDTO(dto);
        // 1.查询es获取商品sku idList  再从mysql捞取实时数据  mysql数据最准确
        Page<List<GoodsSkuSearchAdaptDTO>> page = goodsSearchAdapt.goodsSearch(paramDTO);
        List<String> skuIdList = page.getData().stream().map(GoodsSkuSearchAdaptDTO::getId).collect(Collectors.toList());
        List<GoodsSkuBaseDTO> list = goodsSkuService.queryBySkuIdList(skuIdList);
        Page<List<GoodsSkuBaseDTO>> build =new Page<>();
        build.setCurrentPage(page.getCurrentPage());
        build.setPageSize(page.getPageSize());
        build.setTotal(page.getTotal());
        build.setData(list);
        return goodsConvert.convertToQuerySkuListGoodsBaseDTO(build);
    }

    @Override
    public GoodsSkuDetailDTO getGoodsSkuDetail(String goodsId, String skuId) {
        //1.获取spu基本信息
        GoodsBaseDTO goodsBaseDTO = goodsRepository.getGoodsById(goodsId);
        //商品下架||商品未审核通过||商品删除，则提示：商品已下架
        if (GoodsStatusEnum.DOWN.name().equals(goodsBaseDTO.getMarketEnable()) || !GoodsAuthEnum.PASS.name().equals(goodsBaseDTO.getAuthFlag())){
            return null;
        }
        GoodsDetailBaseDTO goodsDetailBaseDTO = goodsConvert.convertToGoodsDetailBaseDTO(goodsBaseDTO);
        CompletableFuture.supplyAsync(()-> fillCategoryNameList(goodsDetailBaseDTO),executor)
                         .thenCombine(CompletableFuture.supplyAsync(()-> queryGalleryList(goodsDetailBaseDTO),executor),this::fillGalleryList)
                         .thenCombine(CompletableFuture.supplyAsync(()-> queryWholesaleList(goodsDetailBaseDTO),executor),this::fillWholesaleList)
                         .thenCombine(CompletableFuture.supplyAsync(()-> queryGoodsSkuBaseDetailList(goodsDetailBaseDTO.getId()),executor),this::fillGoodsSkuBaseDetailList)
                         .exceptionally(throwable -> {
                             log.error("并发查询商品详情异常",throwable);
                             return null;
                         }).join();

        List<GoodsSkuBaseDetailDTO> detailDTOS = goodsDetailBaseDTO.getSkuList().stream().filter(skuInfo -> Objects.equals(String.valueOf(skuInfo.getId()), skuId)).collect(Collectors.toList());
        if(CollectionUtils.isEmpty(detailDTOS)){
            return null;
        }
        GoodsSkuBaseDetailDTO goodsSkuBaseDetailDTO = detailDTOS.get(0);
        goodsSkuBaseDetailDTO.setPromotionFlag(false);
        goodsSkuBaseDetailDTO.setPromotionPrice(null);
        List<GoodsSkuSpecDTO> goodsSkuSpecDTOS = this.groupBySkuAndSpec(goodsDetailBaseDTO.getSkuList());
        return GoodsSkuDetailDTO.builder()
                  .data(goodsSkuBaseDetailDTO)
                 .wholesaleList(goodsDetailBaseDTO.getWholesaleList())
                 .categoryName(goodsDetailBaseDTO.getCategoryName())
                 .promotionMap(new HashMap<>())
                 .specs(goodsSkuSpecDTOS).build();
    }


    private Map<String,Object> queryPromotionMap(GoodsDetailBaseDTO goodsDetailBaseDTO) {
        // TODO
        return Maps.newHashMap();
    }

    /**
     * @Description 查询当前sku详情
     * @author liuhu
     * @param goodsDetailBaseDTO
     * @param goodsSkuBaseDTOS
     * @date 2022/6/27 10:56
     * @return com.rainbow.mall.goods.service.pojo.dto.service.goods.GoodsDetailBaseDTO
     */
    private GoodsDetailBaseDTO fillGoodsSkuBaseDetailList(GoodsDetailBaseDTO goodsDetailBaseDTO, List<GoodsSkuBaseDetailDTO> goodsSkuBaseDTOS) {
        goodsDetailBaseDTO.setSkuList(goodsSkuBaseDTOS);
        return goodsDetailBaseDTO;
    }

    private List<GoodsSkuBaseDetailDTO> queryGoodsSkuBaseDetailList(String goodsId) {
        List<GoodsSkuBaseDTO> goodsSkuBaseDTOS = goodsSkuService.getByGoodsId(goodsId);
        return goodsSkuBaseDTOS.stream().map(v -> {
            return goodsSkuService.getSkuDetailInfo(String.valueOf(v.getId()));
        }).collect(Collectors.toList());
    }

    private GoodsDetailBaseDTO fillWholesaleList(GoodsDetailBaseDTO goodsDetailBaseDTO, List<WholesaleDTO> wholesaleDTOS) {
        goodsDetailBaseDTO.setWholesaleList(wholesaleDTOS);
        return goodsDetailBaseDTO;
    }

    private List<WholesaleDTO> queryWholesaleList(GoodsDetailBaseDTO goodsDetailBaseDTO) {
        return Lists.newArrayList();
    }

    /**
     * @Description 图片资源
     * @author liuhu
     * @param goodsDetailBaseDTO
     * @param galleryBaseDTOS
     * @date 2022/6/27 10:56
     * @return com.rainbow.mall.goods.service.pojo.dto.service.goods.GoodsDetailBaseDTO
     */
    private GoodsDetailBaseDTO fillGalleryList(GoodsDetailBaseDTO goodsDetailBaseDTO, List<GoodsGalleryBaseDTO> galleryBaseDTOS) {
        List<String> galleryList = galleryBaseDTOS.stream().map(GoodsGalleryBaseDTO::getOriginal).collect(Collectors.toList());
        goodsDetailBaseDTO.setGoodsGalleryList(galleryList);
        return goodsDetailBaseDTO;
    }

    private List<GoodsGalleryBaseDTO> queryGalleryList(GoodsDetailBaseDTO goodsDetailBaseDTO) {
        return goodsGalleryService.queryByList(goodsDetailBaseDTO.getId());
    }

    /**
     * @Description 分类名称
     * @author liuhu
     * @param goodsDetailBaseDTO
     * @date 2022/6/27 10:56
     * @return com.rainbow.mall.goods.service.pojo.dto.service.goods.GoodsDetailBaseDTO
     */
    private GoodsDetailBaseDTO fillCategoryNameList(GoodsDetailBaseDTO goodsDetailBaseDTO) {
        if(StringUtils.isBlank(goodsDetailBaseDTO.getCategoryPath())){
            return goodsDetailBaseDTO;
        }
        List<String> categoryIdList = Arrays.asList(goodsDetailBaseDTO.getCategoryPath().split(","));
        List<CategoryBaseDTO> categoryBaseDTOS = categoryService.queryByIdList(categoryIdList);
        List<String> categoryName = categoryBaseDTOS.stream().map(CategoryBaseDTO::getName).collect(Collectors.toList());
        goodsDetailBaseDTO.setCategoryName(categoryName);
        return goodsDetailBaseDTO;
    }

    /**
     * 根据商品分组商品sku及其规格信息
     *
     * @param goodsSkuVOList 商品VO列表
     * @return 分组后的商品sku及其规格信息
     */
    private List<GoodsSkuSpecDTO> groupBySkuAndSpec(List<GoodsSkuBaseDetailDTO> goodsSkuVOList) {

        List<GoodsSkuSpecDTO> skuSpecVOList = new ArrayList<>();
        for (GoodsSkuBaseDetailDTO goodsSkuVO : goodsSkuVOList) {
            GoodsSkuSpecDTO specVO = new GoodsSkuSpecDTO();
            specVO.setSkuId(goodsSkuVO.getId());
            specVO.setSpecValues(goodsSkuVO.getSpecList());
            specVO.setQuantity(goodsSkuVO.getQuantity());
            skuSpecVOList.add(specVO);
        }
        return skuSpecVOList;
    }


    private void createGoodsSku(GoodsBaseDTO goodsBaseDTO, List<Map<String, Object>> skuList) {
        goodsSkuService.createGoodsSku(goodsBaseDTO,skuList);
    }


    private void checkGoods(GoodsBaseDTO goodsBaseDTO) {
       checkGoodsFreight(goodsBaseDTO);
    }

    /**
     * @Description 校验商品运费模板
     * @author liuhu
     * @param goodsBaseDTO
     * @date 2022/6/12 18:29
     * @return void
     */
    private void checkGoodsFreight(GoodsBaseDTO goodsBaseDTO) {
        GoodsTypeEnum typeEnum = GoodsTypeEnum.getByValue(goodsBaseDTO.getGoodsType());
        if(Objects.isNull(typeEnum)){
            throw new GoodsServiceException(ResultCode.GOODS_TYPE_ERROR.message());
        }
        switch (typeEnum) {
            case PHYSICAL_GOODS:
                if (Objects.equals(0L,goodsBaseDTO.getTemplateId())) {
                    throw new GoodsServiceException(ResultCode.PHYSICAL_GOODS_NEED_TEMP.message());
                }
                break;
            case VIRTUAL_GOODS:
                if (!Objects.equals(0L,goodsBaseDTO.getTemplateId())) {
                    throw new GoodsServiceException(ResultCode.VIRTUAL_GOODS_NOT_NEED_TEMP.message());
                }
                break;
            default:
        }
    }

    /**
     * @Description 构建商品入参
     * @author liuhu
     * @param goodsCreateDTO
     * @date 2022/6/12 18:29
     * @return com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO
     */
    private GoodsBaseDTO buildInsertGoods(GoodsCreateDTO goodsCreateDTO) {
        GoodsBaseDTO goodsBaseDTO = goodsConvert.convertToGoodsBaseDTO(goodsCreateDTO);
        if (CollectionUtils.isNotEmpty(goodsCreateDTO.getGoodsParamsDTOList())) {
            String productParams = JSON.toJSONString(goodsCreateDTO.getGoodsParamsDTOList());
            goodsBaseDTO.setParams(productParams);
        }
        goodsBaseDTO.setMarketEnable(Boolean.TRUE.equals(goodsCreateDTO.getRelease()) ? GoodsStatusEnum.UPPER.name() : GoodsStatusEnum.DOWN.name());
        goodsBaseDTO.setGrade(100D);
        //评论次数
        goodsBaseDTO.setCommentNum(0);
        //购买次数
        goodsBaseDTO.setBuyCount(0);
        //购买次数
        goodsBaseDTO.setQuantity(0);
        //商品评分
        goodsBaseDTO.setGrade(100.0);
        goodsBaseDTO.setSn(String.valueOf(SnowFlakeUtil.snowflakeId()));
        //获取商品系统配置决定是否审核
//        Setting setting = settingService.get(SettingEnum.GOODS_SETTING.name());
//        GoodsSetting goodsSetting = JSONUtil.toBean(setting.getSettingValue(), GoodsSetting.class);
//        //是否需要审核
//        goods.setAuthFlag(Boolean.TRUE.equals(goodsSetting.getGoodsCheck()) ? GoodsAuthEnum.TOBEAUDITED.name() : GoodsAuthEnum.PASS.name());
        goodsBaseDTO.setAuthFlag("PASS");
//        if (Objects.requireNonNull(UserContext.getCurrentUser()).getRole().equals(UserEnums.STORE)) {
//            StoreVO storeDetail = this.storeService.getStoreDetail();
        goodsBaseDTO.setStoreId(54561L);
        goodsBaseDTO.setStoreName("lhtest");
        goodsBaseDTO.setSelfOperated(Boolean.FALSE);
        buildImage(goodsBaseDTO);
//        } else {
//            throw new ServiceException(ResultCode.STORE_NOT_LOGIN_ERROR);
//        }
        return goodsBaseDTO;
    }

    private void buildImage(GoodsBaseDTO goodsBaseDTO) {
        goodsBaseDTO.setOriginal("https://lilishop-oss.oss-cn-beijing.aliyuncs.com/83df593e6ba448ddbe6685d928e6fa65.jpg");
        goodsBaseDTO.setSmall("https://lilishop-oss.oss-cn-beijing.aliyuncs.com/83df593e6ba448ddbe6685d928e6fa65.jpg?x-oss-process=style/200X200");
        goodsBaseDTO.setThumbnail("https://lilishop-oss.oss-cn-beijing.aliyuncs.com/83df593e6ba448ddbe6685d928e6fa65.jpg?x-oss-process=style/400X400");
    }
}