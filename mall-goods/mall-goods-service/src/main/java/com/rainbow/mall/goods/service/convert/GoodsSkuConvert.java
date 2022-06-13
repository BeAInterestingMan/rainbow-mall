package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.goods.service.entity.GoodsSku;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsSkuConvert {
    GoodsSkuBaseDTO convertToGoodsSkuBaseDTO(GoodsBaseDTO goodsBaseDTO);

    GoodsSku convertToGoodsSku(GoodsSkuBaseDTO skuBaseDTO);
}
