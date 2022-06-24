package com.rainbow.mall.goods.service.service;

import com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO;
import com.rainbow.mall.goods.service.pojo.entity.GoodsGallery;

import java.util.List;

public interface GoodsGalleryService {

    /**
     * 根据原图获取缩略图
     *
     * @param origin 原图地址
     * @return 商品相册
     */
    GoodsGallery getGoodsGallery(String origin);
    /**
     * @Description spuID查询
     * @author liuhu
    * @param goodsId
     * @date 2022/6/23 22:55
     * @return java.util.List<com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO>
     */
    List<GoodsGalleryBaseDTO> queryByList(String goodsId);
}
