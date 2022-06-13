package com.rainbow.mall.goods.service.pojo.dto.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("商品批发规则")
public class WholesaleDTO implements Serializable {

    @ApiModelProperty(value = "商品ID")
    private String goodsId;

    @ApiModelProperty(value = "SkuID")
    private String skuId;

    @ApiModelProperty(value = "数量")
    private Integer num;

    @ApiModelProperty(value = "金额")
    private Double price;

}
