package com.rainbow.mall.goods.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
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
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.GoodsCreateDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QueryGoodsSkuListDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO;
import com.rainbow.mall.goods.service.repository.GoodsRepository;
import com.rainbow.mall.goods.service.service.GoodsGalleryService;
import com.rainbow.mall.goods.service.service.GoodsService;
import com.rainbow.mall.goods.service.service.GoodsSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
          throw new GoodsServiceException(ResultCode.GOODS_ERROR);
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
    public Map<String, Object> getGoodsSkuDetail(String goodsId, String skuId) {
       getGoodsBaseDetail(goodsId);
       if(Objects.isNull(goodsBaseDTO)){
           return null;
       }
        //商品下架||商品未审核通过||商品删除，则提示：商品已下架
        if (GoodsStatusEnum.DOWN.name().equals(goodsBaseDTO.getMarketEnable()) || !GoodsAuthEnum.PASS.name().equals(goodsBaseDTO.getAuthFlag())){
           return null;
        }
        GoodsSkuBaseDetailDTO skuDetailInfo = goodsSkuService.getSkuDetailInfo(skuId);
        return null;
    }

    private void getGoodsBaseDetail(String goodsId) {
        GoodsBaseDTO goodsBaseDTO = goodsRepository.getGoodsById(goodsId);
        List<GoodsGalleryBaseDTO> galleryBaseDTOS = goodsGalleryService.queryByList(goodsId);
        List<String> galleryList = galleryBaseDTOS.stream().map(GoodsGalleryBaseDTO::getOriginal).collect(Collectors.toList());
        goodsVO.setGoodsGalleryList(galleryList);
        goodsSkuService.getSkuDetailInfo(goodsId);
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
            throw new GoodsServiceException(ResultCode.GOODS_TYPE_ERROR);
        }
        switch (typeEnum) {
            case PHYSICAL_GOODS:
                if (Objects.equals(0L,goodsBaseDTO.getTemplateId())) {
                    throw new GoodsServiceException(ResultCode.PHYSICAL_GOODS_NEED_TEMP);
                }
                break;
            case VIRTUAL_GOODS:
                if (!Objects.equals(0L,goodsBaseDTO.getTemplateId())) {
                    throw new GoodsServiceException(ResultCode.VIRTUAL_GOODS_NOT_NEED_TEMP);
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