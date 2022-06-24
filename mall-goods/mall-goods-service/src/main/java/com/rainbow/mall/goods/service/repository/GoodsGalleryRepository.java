package com.rainbow.mall.goods.service.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbow.mall.goods.service.convert.GoodsGalleryConvert;
import com.rainbow.mall.goods.service.mapper.GoodsGalleryMapper;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO;
import com.rainbow.mall.goods.service.pojo.entity.GoodsGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
public class  GoodsGalleryRepository {

    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;

    @Autowired
    private GoodsGalleryConvert goodsGalleryConvert;

    public List<GoodsGalleryBaseDTO> queryByList(String goodsId) {
        LambdaQueryWrapper<GoodsGallery> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(GoodsGallery::getGoodsId,goodsId);
        List<GoodsGallery> goodsGalleries = goodsGalleryMapper.selectList(queryWrapper);
        return goodsGalleryConvert.convertToGoodsGalleryBaseDTOList(goodsGalleries);
    }
}
