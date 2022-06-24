package com.rainbow.mall.goods.service.service.impl;

import com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO;
import com.rainbow.mall.goods.service.pojo.entity.GoodsGallery;
import com.rainbow.mall.goods.service.repository.GoodsGalleryRepository;
import com.rainbow.mall.goods.service.service.GoodsGalleryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  @Description 商品相册服务
 *  @author liuhu
 *  @Date 2022/6/12 17:17
 */
@Service
@Slf4j
public class GoodsGalleryServiceImpl implements GoodsGalleryService {

    @Autowired
    private GoodsGalleryRepository goodsGalleryRepository;

    @Override
    public GoodsGallery getGoodsGallery(String origin) {
        return null;
    }

    @Override
    public List<GoodsGalleryBaseDTO> queryByList(String goodsId) {
      return goodsGalleryRepository.queryByList(goodsId);
    }
}
