package com.rainbow.mall.goods.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@ApiModel("买家端小程序-分类页")
public class BuyerCategoryVO implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "分类名称")
    private String name;

    @ApiModelProperty(value = "父id, 根节点为0")
    private String parentId;

    @ApiModelProperty(value = "层级, 从0开始")
    private Integer level;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "分类图标")
    private String image;

    @ApiModelProperty("子分类列表")
    private List<BuyerCategoryVO> children;
}
