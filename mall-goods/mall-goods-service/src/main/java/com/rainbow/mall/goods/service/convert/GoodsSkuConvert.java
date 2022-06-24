package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO;
import com.rainbow.mall.goods.service.pojo.entity.GoodsSku;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsSkuConvert {
    GoodsSkuBaseDTO convertToGoodsSkuBaseDTO(GoodsBaseDTO goodsBaseDTO);

    GoodsSkuBaseDTO convertToGoodsSkuBaseDTO(GoodsSku goodsSku);

    List<GoodsSkuBaseDTO> convertToGoodsSkuBaseDTO(List<GoodsSku> goodsSkuList);

    GoodsSku convertToGoodsSku(GoodsSkuBaseDTO skuBaseDTO);

    GoodsSkuBaseDetailDTO convertToGoodsSkuBaseDetailDTO(GoodsSkuBaseDTO goodsSkuBaseDTO);
}
