package com.rainbow.mall.goods.service.controller;

import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.convert.GoodsCartConvert;
import com.rainbow.mall.goods.service.pojo.dto.service.cart.GoodsCartSaveDTO;
import com.rainbow.mall.goods.service.pojo.request.GoodsCartAddRequest;
import com.rainbow.mall.goods.service.service.GoodsCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
