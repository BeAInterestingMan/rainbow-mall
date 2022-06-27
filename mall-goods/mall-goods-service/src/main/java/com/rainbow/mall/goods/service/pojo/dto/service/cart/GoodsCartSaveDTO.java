package com.rainbow.mall.goods.service.pojo.dto.service.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsCartSaveDTO {

    /**spuId*/
    private String goodsId;

    /**skuId*/
    private String skuId;

    /**名称*/
    private String name;

    /**加入数量*/
    private Integer num;

    /**加入购物车时价格*/
    private BigDecimal price;
}
