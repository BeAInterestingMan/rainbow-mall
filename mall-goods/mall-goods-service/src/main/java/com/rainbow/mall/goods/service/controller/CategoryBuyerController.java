package com.rainbow.mall.goods.service.controller;

import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.convert.CategoryConvert;
import com.rainbow.mall.goods.service.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.service.pojo.vo.BuyerCategoryVO;
import com.rainbow.mall.goods.service.service.CategoryService;
import com.rainbow.mall.search.api.feign.GoodsSearchFeign;
import com.rainbow.mall.search.api.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.api.pojo.response.GoodsSkuSearchResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@Api(tags = "买家端小程序-分类页接口")
@RequestMapping("/goods/category")
public class CategoryBuyerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConvert categoryConvert;

    @Autowired
    private GoodsSearchFeign goodsSearchFeign;

    @ApiOperation(value = "获取商品分类列表")
    @ApiImplicitParam(name = "parentId", value = "上级分类ID，全部分类为：0", required = true, dataType = "Long", paramType = "path")
    @GetMapping(value = "/get/{parentId}")
    public Result<List<BuyerCategoryVO>> queryCategoryList(@NotBlank(message = "分类ID不能为空") @PathVariable String parentId) {
        List<BuyerCategoryDTO> buyerCategoryDTOS = categoryService.queryAllCategory(parentId);
        List<BuyerCategoryVO> buyerCategoryVOS = categoryConvert.convertBuyerCategoryVOList(buyerCategoryDTOS);
        return Result.success(buyerCategoryVOS);
    }

    @ApiOperation(value = "获取商品分类列表")
    @GetMapping(value = "/test")
    public Result<Void> queryGoodList() {
        GoodsSkuSearchRequest request = new GoodsSkuSearchRequest();
        request.setCategoryId("111111");
        Result<Page<List<GoodsSkuSearchResponse>>> search = goodsSearchFeign.search(request);
        System.out.println( JSON.toJSONString(search));
        return Result.success();
    }
}
