package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.goods.service.pojo.dto.base.GoodsGalleryBaseDTO;
import com.rainbow.mall.goods.service.pojo.entity.GoodsGallery;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsGalleryConvert {

    List<GoodsGalleryBaseDTO> convertToGoodsGalleryBaseDTOList(List<GoodsGallery> goodsGalleries);
}
