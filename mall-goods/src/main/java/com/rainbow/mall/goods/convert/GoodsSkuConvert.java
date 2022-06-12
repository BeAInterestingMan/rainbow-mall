package com.rainbow.mall.goods.convert;

import com.rainbow.mall.goods.entity.GoodsSku;
import com.rainbow.mall.goods.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.pojo.dto.base.GoodsSkuBaseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GoodsSkuConvert {
    GoodsSkuBaseDTO convertToGoodsSkuBaseDTO(GoodsBaseDTO goodsBaseDTO);

    GoodsSku convertToGoodsSku(GoodsSkuBaseDTO skuBaseDTO);
}
