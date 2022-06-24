package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.goods.service.adapt.dto.GoodsSkuSearchAdaptDTO;
import com.rainbow.mall.goods.service.adapt.dto.GoodsSkuSearchAdaptParamDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.GoodsCreateDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QueryGoodsSkuListDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.entity.Goods;
import com.rainbow.mall.goods.service.pojo.request.GoodsCreateRequest;
import com.rainbow.mall.goods.service.pojo.request.QueryGoodsSkuListRequest;
import com.rainbow.mall.goods.service.pojo.response.QueryGoodsSkuListResponse;
import com.rainbow.mall.search.api.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.api.pojo.response.GoodsSkuSearchResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GoodsConvert {

    GoodsCreateDTO convertToGoodsCreateDTO(GoodsCreateRequest request);

    GoodsBaseDTO convertToGoodsBaseDTO(GoodsCreateDTO goodsCreateDTO);

    GoodsBaseDTO convertToGoodsBaseDTO(Goods goods);

    Goods convertToGoods(GoodsBaseDTO goodsBaseDTO);

    @Mappings({
            @Mapping(source = "pageNumber",target = "currentPage")
    })
    QueryGoodsSkuListDTO convertToQueryGoodsSkuListDTO(QueryGoodsSkuListRequest request);

    Page<List<QueryGoodsSkuListResponse>> convertToQueryGoodsSkuListResponse(Page<List<QuerySkuListGoodsBaseDTO>> page);

    Page<List<GoodsSkuSearchAdaptDTO>> convertToGoodsSkuSearchAdaptDTOList(Page<List<GoodsSkuSearchResponse>> page);

    GoodsSkuSearchRequest convertToGoodsSkuSearchRequest(GoodsSkuSearchAdaptParamDTO request);

    GoodsSkuSearchAdaptParamDTO convertToGoodsSkuSearchAdaptParamDTO(QueryGoodsSkuListDTO dto);

    Page<List<QuerySkuListGoodsBaseDTO>> convertToGoodsSkuSearchAdaptDTOPage(Page<List<GoodsSkuSearchAdaptDTO>> page);

    Page<List<QuerySkuListGoodsBaseDTO>> convertToQuerySkuListGoodsBaseDTO(Page<List<GoodsSkuBaseDTO>> build);
}
