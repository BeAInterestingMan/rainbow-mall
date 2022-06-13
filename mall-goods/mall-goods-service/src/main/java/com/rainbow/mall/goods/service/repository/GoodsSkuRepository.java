package com.rainbow.mall.goods.service.repository;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.rainbow.mall.goods.service.convert.GoodsSkuConvert;
import com.rainbow.mall.goods.service.entity.GoodsSku;
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
}
