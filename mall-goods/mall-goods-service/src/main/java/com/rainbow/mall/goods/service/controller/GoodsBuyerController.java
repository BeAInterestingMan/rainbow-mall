package com.rainbow.mall.goods.service.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.convert.GoodsConvert;
import com.rainbow.mall.goods.service.pojo.dto.service.QueryGoodsSkuListDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.request.QueryGoodsSkuListRequest;
import com.rainbow.mall.goods.service.pojo.response.QueryGoodsSkuListResponse;
import com.rainbow.mall.goods.service.pojo.vo.BuyerGoodVO;
import com.rainbow.mall.goods.service.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@Slf4j
@Api(tags = "买家端-商品接口")
@RestController
@RequestMapping("/goods/goods")
public class GoodsBuyerController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsConvert goodsConvert;


    @ApiOperation(value = "获取搜索热词")
    @GetMapping("/hot-words")
    public Result<List<String>> getGoodsHotWords(Integer count) {
        return Result.success(Lists.newArrayList("测试11","测试2222"));
    }


    @GetMapping("es")
    @ApiOperation("通用商品搜索接口")
    @ApiImplicitParam(name = "request",value = "通用商品搜索入参")
    public Result<Page<List<QueryGoodsSkuListResponse>>> querySkuList(QueryGoodsSkuListRequest request) throws IOException {
        QueryGoodsSkuListDTO dto = goodsConvert.convertToQueryGoodsSkuListDTO(request);
        Page<List<QuerySkuListGoodsBaseDTO>> page = goodsService.querySkuList(dto);
        return Result.success(goodsConvert.convertToQueryGoodsSkuListResponse(page));
    }
}
