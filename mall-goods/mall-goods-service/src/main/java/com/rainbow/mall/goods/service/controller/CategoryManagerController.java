package com.rainbow.mall.goods.service.controller;

import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.convert.CategoryConvert;
import com.rainbow.mall.goods.service.pojo.dto.service.CategoryAddDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.CategoryUpdateDTO;
import com.rainbow.mall.goods.service.pojo.request.CategoryAddRequest;
import com.rainbow.mall.goods.service.pojo.request.CategoryUpdateRequest;
import com.rainbow.mall.goods.service.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Api(tags = "pc管理端-分类页接口")
@RequestMapping("/manager/goods/category")
@Slf4j
public class CategoryManagerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConvert categoryConvert;

    @ApiOperation(value = "添加商品分类")
    @ApiImplicitParam(name = "request", value = "新增参数")
    @PostMapping
    public Result<Void> addCategoryList(@Valid @RequestBody CategoryAddRequest request) {
        log.info("execute addCategoryList info,req:{}", JSON.toJSONString(request));
        CategoryAddDTO categoryAddDTO = categoryConvert.convertCategoryAddDTO(request);
        categoryService.addCategoryList(categoryAddDTO);
        return Result.success();
    }


    @ApiOperation(value = "修改商品分类")
    @ApiImplicitParam(name = "request", value = "修改参数")
    @PutMapping
    public Result<Void> updateCategoryList(@Valid @RequestBody CategoryUpdateRequest request) {
        log.info("execute updateCategoryList info,req:{}", JSON.toJSONString(request));
        CategoryUpdateDTO categoryUpdateDTO = categoryConvert.convertCategoryUpdateDTO(request);
        categoryService.updateCategoryList(categoryUpdateDTO);
        return Result.success();
    }
}
