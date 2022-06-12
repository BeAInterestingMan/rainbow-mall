package com.rainbow.mall.goods.convert;

import com.rainbow.mall.goods.entity.Goods;
import com.rainbow.mall.goods.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.pojo.dto.service.GoodsCreateDTO;
import com.rainbow.mall.goods.pojo.request.GoodsCreateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsConvert {

    GoodsCreateDTO convertToGoodsCreateDTO(GoodsCreateRequest request);

    GoodsBaseDTO convertToGoodsBaseDTO(GoodsCreateDTO goodsCreateDTO);

    Goods convertToGoods(GoodsBaseDTO goodsBaseDTO);
}
