package com.rainbow.mall.goods.service.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@ApiModel("购物车新增请求接口")
public class GoodsCartAddRequest {

    @ApiModelProperty(name = "skuId",value = "skuId")
    @NotBlank(message = "skuId不能为空")
    private String skuId;

    @ApiModelProperty(name = "数量",value = "加入数量")
    @NotNull(message = "num不能为空")
    @Min(value = 0)
    private Integer num;
}
