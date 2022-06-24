package com.rainbow.mall.goods.service.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbow.mall.goods.service.convert.GoodsConvert;
import com.rainbow.mall.goods.service.pojo.entity.Goods;
import com.rainbow.mall.goods.service.mapper.GoodsMapper;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
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

    public GoodsBaseDTO getGoodsById(String goodsId) {
        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Goods::getId,goodsId)
                    .eq(Goods::getDeleteFlag,false);
        Goods goodsList = goodsMapper.selectOne(queryWrapper);
        return goodsConvert.convertToGoodsBaseDTO(goodsList);
    }
}
