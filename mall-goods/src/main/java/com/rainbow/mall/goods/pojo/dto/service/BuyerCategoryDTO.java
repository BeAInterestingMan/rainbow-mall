package com.rainbow.mall.goods.pojo.dto.service;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Data
@ApiModel("买家端小程序-分类页")
public class BuyerCategoryDTO implements Serializable {

    private String id;

    /**分类名称0*/
    private String name;

    /**父id, 根节点为0*/
    private String parentId;

    /**层级, 从0开始*/
    private Integer level;

    /**排序值*/
    private BigDecimal sortOrder;

     /**佣金比例*/
    private Double commissionRate;

    /**分类图标*/
    private String image;

    /**子分类列表*/
    private List<BuyerCategoryDTO> children;
}
