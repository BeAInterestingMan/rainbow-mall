package com.rainbow.mall.goods.service.pojo.dto.service.goods;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author paulG
 * @since 2022/5/20
 **/
@Data
@ApiModel(value = "批发商品")
public class Wholesale  {


    @ApiModelProperty(value = "唯一标识", hidden = true)
    private String id;

    @ApiModelProperty(value = "商品ID")
    private String goodsId;
    @ApiModelProperty(value = "SkuID")
    private String skuId;
    @ApiModelProperty(value = "数量")
    private Integer num;
    @ApiModelProperty(value = "金额")
    private Double price;
}
