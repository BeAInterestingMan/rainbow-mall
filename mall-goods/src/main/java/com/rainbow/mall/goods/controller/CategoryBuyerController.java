package com.rainbow.mall.goods.controller;

import com.rainbow.mall.common.core.dto.base.Result;
import com.rainbow.mall.goods.convert.CategoryConvert;
import com.rainbow.mall.goods.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.pojo.vo.BuyerCategoryVO;
import com.rainbow.mall.goods.service.CategoryService;
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

    @ApiOperation(value = "获取商品分类列表")
    @ApiImplicitParam(name = "parentId", value = "上级分类ID，全部分类为：0", required = true, dataType = "Long", paramType = "path")
    @GetMapping(value = "/get/{parentId}")
    public Result<List<BuyerCategoryVO>> list(@NotBlank(message = "分类ID不能为空") @PathVariable String parentId) {
        List<BuyerCategoryDTO> buyerCategoryDTOS = categoryService.queryAllCategory(parentId);
        List<BuyerCategoryVO> buyerCategoryVOS = categoryConvert.convertBuyerCategoryVOList(buyerCategoryDTOS);
        return Result.success(buyerCategoryVOS);
    }
}
