package com.rainbow.mall.goods.service.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
@ApiModel("买家端小程序-分类页")
public class BuyerGoodVO implements Serializable {

    @ApiModelProperty(value = "id")
    private List<BuyexxDTO> content;

    @ApiModelProperty(value = "分类名称")
    private Long size;

    @ApiModelProperty(value = "分类名称")
    private Integer number;

    @ApiModelProperty(value = "父id, 根节点为0")
    private Long totalElements;

    @ApiModelProperty(value = "层级, 从0开始")
    private Integer totalPages;
}
