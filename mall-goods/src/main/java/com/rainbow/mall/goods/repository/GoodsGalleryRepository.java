package com.rainbow.mall.goods.repository;

import com.rainbow.mall.goods.mapper.GoodsGalleryMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
public class  GoodsGalleryRepository {

    @Autowired
    private GoodsGalleryMapper goodsGalleryMapper;
	
}
