package com.rainbow.mall.search.service.convert;


import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.search.service.pojo.dto.GoodsBaseDTO;
import com.rainbow.mall.search.service.pojo.dto.GoodsSkuSearchDTO;
import com.rainbow.mall.search.service.pojo.po.GoodsEntity;
import com.rainbow.mall.search.service.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.service.pojo.response.GoodsSkuSearchResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsSkuSearchConvert {

    GoodsSkuSearchDTO convertToGoodsSkuSearchDTO(GoodsSkuSearchRequest request);

    Page<List<GoodsBaseDTO>> convertToGoodsSearchPage(Page<List<GoodsEntity>> originPage);

    Page<List<GoodsSkuSearchResponse>> convertToGoodsSkuSearchResponsePage(Page<List<GoodsBaseDTO>>  originPage);
}
