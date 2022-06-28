package com.rainbow.mall.goods.service.controller;

import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.convert.GoodsCartConvert;
import com.rainbow.mall.goods.service.pojo.dto.service.cart.GoodsCartSaveDTO;
import com.rainbow.mall.goods.service.pojo.request.GoodsCartAddRequest;
import com.rainbow.mall.goods.service.service.GoodsCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@Api(tags = "买家端-购物车接口")
@RequestMapping("/buyer/trade/carts")
public class GoodsCartController {

    @Autowired
    private GoodsCartService goodsCartService;

    @Autowired
    private GoodsCartConvert goodsCartConvert;

    @ApiOperation(value = "向购物车中添加一个产品")
    @PostMapping
    @ApiImplicitParam(name = "request", value = "购物车添加接口入参", required = true)
    public Result<Void> add(@Valid @RequestBody GoodsCartAddRequest request) {
        GoodsCartSaveDTO goodsCartAddDTO = goodsCartConvert.convertToGoodsCartAddDTO(request);
        goodsCartService.add(goodsCartAddDTO);
        return Result.success();
    }

    @ApiOperation(value = "批量删除购物车产品")
    @DeleteMapping
    @ApiImplicitParam(name = "request", value = "清空购物车接口入参", required = true)
    public Result<Void> clean() {
        goodsCartService.clean();
        return Result.success();
    }

    @ApiOperation(value = "删除购物车中的一个或多个产品")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "skuIds", value = "sku ids", required = true)
    })
    @DeleteMapping(value = "/sku/remove")
    public Result<Object> delete(String[] skuIds) {
        goodsCartService.delete(skuIds);
        return Result.success();
    }


    @ApiOperation(value = "获取购物车数量")
    @GetMapping("/count")
    public Result<Integer> cartCount() {
        return Result.success(goodsCartService.getCartNum());
    }

}
