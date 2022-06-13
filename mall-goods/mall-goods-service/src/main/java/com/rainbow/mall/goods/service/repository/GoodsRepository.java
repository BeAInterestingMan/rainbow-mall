package com.rainbow.mall.goods.service.repository;

import com.rainbow.mall.goods.service.convert.GoodsConvert;
import com.rainbow.mall.goods.service.entity.Goods;
import com.rainbow.mall.goods.service.mapper.GoodsMapper;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
public class  GoodsRepository {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private GoodsConvert goodsConvert;

    public GoodsBaseDTO insertGoods(GoodsBaseDTO goodsBaseDTO) {
        Goods goods = goodsConvert.convertToGoods(goodsBaseDTO);
        if(Objects.isNull(goods)){
            return null;
        }
        goodsMapper.insert(goods);
        goodsBaseDTO.setId(goods.getId());
        return goodsBaseDTO;
    }
}
