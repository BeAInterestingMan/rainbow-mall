package com.rainbow.mall.goods.service;

import com.rainbow.mall.goods.entity.GoodsGallery;

public interface GoodsGalleryService {

    /**
     * 根据原图获取缩略图
     *
     * @param origin 原图地址
     * @return 商品相册
     */
    GoodsGallery getGoodsGallery(String origin);
}
