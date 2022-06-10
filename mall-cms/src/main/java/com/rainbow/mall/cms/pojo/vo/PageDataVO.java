package com.rainbow.mall.cms.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("买家端-页面数据相应")
public class PageDataVO {


    @ApiModelProperty(value = "页面数据")
    private String pageData;
}
