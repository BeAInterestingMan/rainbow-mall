package com.rainbow.mall.goods.service.pojo.dto.service.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsCartSaveDTO {


    /**skuId*/
    private String skuId;

    /**加入数量*/
    private Integer num;
}
