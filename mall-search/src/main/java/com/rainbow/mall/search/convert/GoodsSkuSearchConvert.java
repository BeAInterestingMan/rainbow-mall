package com.rainbow.mall.search.convert;


import com.rainbow.mall.common.core.dto.base.Page;
import com.rainbow.mall.search.pojo.dto.GoodsBaseDTO;
import com.rainbow.mall.search.pojo.dto.GoodsSkuSearchDTO;
import com.rainbow.mall.search.pojo.po.GoodsEntity;
import com.rainbow.mall.search.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.pojo.response.GoodsSkuSearchResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsSkuSearchConvert {

    GoodsSkuSearchDTO convertToGoodsSkuSearchDTO(GoodsSkuSearchRequest request);

    Page<List<GoodsBaseDTO>> convertToGoodsSearchPage(Page<List<GoodsEntity>> originPage);

    Page<List<GoodsSkuSearchResponse>> convertToGoodsSkuSearchResponsePage(Page<List<GoodsBaseDTO>>  originPage);
}
