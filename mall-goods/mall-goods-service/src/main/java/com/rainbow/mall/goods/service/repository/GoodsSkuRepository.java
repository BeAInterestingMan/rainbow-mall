package com.rainbow.mall.goods.service.repository;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.google.common.collect.Lists;
import com.rainbow.mall.common.datasource.helper.MybatisBatchHelper;
import com.rainbow.mall.goods.service.convert.GoodsSkuConvert;
import com.rainbow.mall.goods.service.pojo.entity.GoodsSku;
import com.rainbow.mall.goods.service.mapper.GoodsSkuMapper;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
@Slf4j
public class  GoodsSkuRepository {

    @Autowired
    private GoodsSkuMapper goodsSkuMapper;

    @Autowired
    private GoodsSkuConvert goodsSkuConvert;

    @Autowired
    private MybatisBatchHelper mybatisBatchHelper;

    public void insertBatch(List<GoodsSkuBaseDTO> skuBaseDTOS) {
        if(CollectionUtils.isEmpty(skuBaseDTOS)){
            return;
        }
        List<GoodsSku> goodsSkuList = goodsSkuConvert.convertToGoodsSkuList(skuBaseDTOS);
        int count = mybatisBatchHelper.batchInsertOrUpdate(goodsSkuList, GoodsSkuMapper.class, BaseMapper::insert);
        if(count != skuBaseDTOS.size()){
            log.warn("更新数量不等于传入数量，req:{}", JSON.toJSONString(skuBaseDTOS));
        }
    }

    public List<GoodsSkuBaseDTO> queryBySkuIdList(List<String> skuIdList) {
        if(CollectionUtils.isEmpty(skuIdList)){
            return Lists.newArrayList();
        }
        LambdaQueryWrapper<GoodsSku> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(GoodsSku::getId,skuIdList);
        List<GoodsSku> goodsSkus = goodsSkuMapper.selectList(lambdaQueryWrapper);
        return goodsSkuConvert.convertToGoodsSkuBaseDTO(goodsSkus);
    }
}
