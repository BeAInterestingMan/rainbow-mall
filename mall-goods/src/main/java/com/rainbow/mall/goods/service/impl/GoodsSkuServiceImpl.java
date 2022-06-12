package com.rainbow.mall.goods.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.rainbow.mall.common.core.utils.BigDecimalUtil;
import com.rainbow.mall.common.core.utils.SnowFlakeUtil;
import com.rainbow.mall.goods.convert.GoodsSkuConvert;
import com.rainbow.mall.goods.enums.ResultCode;
import com.rainbow.mall.goods.exception.GoodsServiceException;
import com.rainbow.mall.goods.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.pojo.dto.base.GoodsSkuBaseDTO;
import com.rainbow.mall.goods.repository.GoodsSkuRepository;
import com.rainbow.mall.goods.service.GoodsSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class GoodsSkuServiceImpl  implements GoodsSkuService {

    @Autowired
    private GoodsSkuConvert goodsSkuConvert;

    @Autowired
    private GoodsSkuRepository goodsSkuRepository;

    @Override
    public void createGoodsSku(GoodsBaseDTO goodsBaseDTO, List<Map<String, Object>> skuList) {
        if(CollectionUtils.isEmpty(skuList)){
            throw new GoodsServiceException(ResultCode.MUST_HAVE_GOODS_SKU);
        }
        insertSkuList(goodsBaseDTO,skuList);
        // TODO 库存服务拆分
    }

    private void insertSkuList(GoodsBaseDTO goodsBaseDTO, List<Map<String, Object>> skuList) {
        List<GoodsSkuBaseDTO> skuBaseDTOS = skuList.stream().map(skuInfo -> {
            return buildInsertGoodSku(skuInfo, goodsBaseDTO);
        }).collect(Collectors.toList());
        goodsSkuRepository.insertBatch(skuBaseDTOS);
    }

    private GoodsSkuBaseDTO buildInsertGoodSku(Map<String, Object> skuInfo, GoodsBaseDTO goodsBaseDTO) {
        GoodsSkuBaseDTO goodsSkuBaseDTO = goodsSkuConvert.convertToGoodsSkuBaseDTO(goodsBaseDTO);
        //规格简短信息
        StringBuilder simpleSpecs = new StringBuilder();
        //商品名称
        StringBuilder goodsSkuName = new StringBuilder(goodsSkuBaseDTO.getGoodsName());
        //规格值
        Map<String, Object> specMap = new HashMap<>(16);
        // 原始规格项
        ArrayList<String> baseSpecList = Lists.newArrayList("id", "sn", "cost", "price", "quantity", "weight","images");
        //获取规格信息
        for (Map.Entry<String, Object> spec : skuInfo.entrySet()) {
            if(Objects.isNull(spec.getValue())){
                continue;
            }
            //保存新增规格信息
            if (!baseSpecList.contains(spec.getKey())) {
                specMap.put(spec.getKey(), spec.getValue());
                //设置商品名称
                goodsSkuName.append(" ").append(spec.getValue());
                //规格简短信息
                simpleSpecs.append(" ").append(spec.getValue());
            }
        }
        goodsSkuBaseDTO.setId(null);
        goodsSkuBaseDTO.setGoodsId(goodsBaseDTO.getId());
        goodsSkuBaseDTO.setGoodsName(goodsSkuName.toString());
        //设置规格信息
        goodsSkuBaseDTO.setSn(String.valueOf(SnowFlakeUtil.snowflakeId()));
        goodsSkuBaseDTO.setWeight(BigDecimalUtil.convertToBigDecimal(skuInfo.get("weight")));
        goodsSkuBaseDTO.setPrice(BigDecimalUtil.convertToBigDecimal(skuInfo.get("price")));
        goodsSkuBaseDTO.setCost(BigDecimalUtil.convertToBigDecimal(skuInfo.get("cost")));
        goodsSkuBaseDTO.setQuantity(0);
        goodsSkuBaseDTO.setSpecs(JSON.toJSONString(specMap));
        goodsSkuBaseDTO.setSimpleSpecs(simpleSpecs.toString());
        fillImage(goodsSkuBaseDTO);
        return goodsSkuBaseDTO;
    }

    private void fillImage(GoodsSkuBaseDTO goodsSkuBaseDTO) {
        goodsSkuBaseDTO.setOriginal("https://lilishop-oss.oss-cn-beijing.aliyuncs.com/83df593e6ba448ddbe6685d928e6fa65.jpg");
        goodsSkuBaseDTO.setSmall("https://lilishop-oss.oss-cn-beijing.aliyuncs.com/83df593e6ba448ddbe6685d928e6fa65.jpg?x-oss-process=style/200X200");
        goodsSkuBaseDTO.setThumbnail("https://lilishop-oss.oss-cn-beijing.aliyuncs.com/83df593e6ba448ddbe6685d928e6fa65.jpg?x-oss-process=style/400X400");
    }
}