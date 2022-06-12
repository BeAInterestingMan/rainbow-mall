package com.rainbow.mall.search.controller;

import com.rainbow.mall.common.core.dto.base.Page;
import com.rainbow.mall.common.core.dto.base.Result;
import com.rainbow.mall.search.convert.GoodsSkuSearchConvert;
import com.rainbow.mall.search.pojo.dto.GoodsBaseDTO;
import com.rainbow.mall.search.pojo.dto.GoodsSkuSearchDTO;
import com.rainbow.mall.search.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.pojo.response.GoodsSkuSearchResponse;
import com.rainbow.mall.search.service.GoodsSkuSearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequestMapping("/goods/goods/")
@Api(tags = "商品搜索")
@RestController
public class GoodsSearchController {

    @Autowired
    private GoodsSkuSearchService skuSearchService;

    @Autowired
    private GoodsSkuSearchConvert goodsSkuSearchConvert;

    @GetMapping("es")
    @ApiOperation("通用商品搜索")
    @ApiImplicitParam(name = "request",value = "通用商品搜索入参")
    public Result<Page<List<GoodsSkuSearchResponse>>> search(GoodsSkuSearchRequest request) throws IOException {
        GoodsSkuSearchDTO dto = goodsSkuSearchConvert.convertToGoodsSkuSearchDTO(request);
        Page<List<GoodsBaseDTO>> search = skuSearchService.search(dto);
        return Result.success(goodsSkuSearchConvert.convertToGoodsSkuSearchResponsePage(search));
    }
}
