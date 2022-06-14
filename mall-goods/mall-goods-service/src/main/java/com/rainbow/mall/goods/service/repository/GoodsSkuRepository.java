package com.rainbow.mall.goods.service.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.rainbow.mall.goods.service.convert.GoodsSkuConvert;
import com.rainbow.mall.goods.service.pojo.entity.GoodsSku;
import com.rainbow.mall.goods.service.mapper.GoodsSkuMapper;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
public class  GoodsSkuRepository {

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @Autowired
    private GoodsSkuConvert goodsSkuConvert;

    public void insertBatch(List<GoodsSkuBaseDTO> skuBaseDTOS) {
        if(CollectionUtils.isEmpty(skuBaseDTOS)){
            return;
        }
        // TODO DB HELPER 改造
        for (GoodsSkuBaseDTO skuBaseDTO : skuBaseDTOS) {
            GoodsSku goodsSku = goodsSkuConvert.convertToGoodsSku(skuBaseDTO);
            goodsSkuMapper.insert(goodsSku);
        }
    }

    public List<GoodsSkuBaseDTO> queryBySkuIdList(List<String> skuIdList) {
        if(CollectionUtils.isEmpty(skuIdList)){
            return Lists.newArrayList();
        }
        LambdaQueryWrapper<GoodsSku> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(GoodsSku::getId,skuIdList);
        List<GoodsSku> goodsSkus = goodsSkuMapper.selectList(lambdaQueryWrapper);
        return goodsSkuConvert.convertToGoodsSkuBaseDTO(goodsSkus);
    }
}
