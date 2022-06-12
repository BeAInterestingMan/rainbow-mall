package com.rainbow.mall.goods.pojo.dto.service;

import lombok.Data;

@Data
public class CategoryUpdateDTO {

    private String id;

    /**分类名称*/
    private String name;

    /**父id, 根节点为0*/
    private String parentId;

    /**层级不能为空*/
    private Integer level;

    /**排序值不能为空*/
    private Integer sortOrder;

    /**佣金比例*/
    private Double commissionRate;

    /**分类图标*/
    private String image;
}
