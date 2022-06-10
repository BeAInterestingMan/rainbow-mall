package com.rainbow.mall.goods.pojo.dto.base;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class CategoryBaseDTO implements Serializable {


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

    /**是否支持频道*/
    private Boolean supportChannel;
}
