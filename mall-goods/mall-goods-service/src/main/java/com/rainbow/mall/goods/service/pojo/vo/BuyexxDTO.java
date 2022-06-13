package com.rainbow.mall.goods.service.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@Data
@ApiModel("买家端小程序-分类页")
public class BuyexxDTO implements Serializable {

    @ApiModelProperty(value = "id")
    private EsGoodsIndex content;

    @ApiModelProperty(value = "分类名称")
    private String index;
}
