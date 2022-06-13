package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.goods.service.entity.Goods;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.GoodsCreateDTO;
import com.rainbow.mall.goods.service.pojo.request.GoodsCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsConvert {

    GoodsCreateDTO convertToGoodsCreateDTO(GoodsCreateRequest request);

    GoodsBaseDTO convertToGoodsBaseDTO(GoodsCreateDTO goodsCreateDTO);

    Goods convertToGoods(GoodsBaseDTO goodsBaseDTO);
}
