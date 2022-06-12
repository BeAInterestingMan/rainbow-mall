package com.rainbow.mall.search.pojo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品属性索引
 **/
@Data
@NoArgsConstructor
public class EsGoodsAttributeDTO implements Serializable {


    /**
     * 属性参数：0->规格；1->参数
     */
    private Integer type;

    /**
     * 属性名称
     */
    private String nameId;

    /**
     * 属性名称
     */
    private String name;

    /**
     * 属性值
     */
    private String valueId;

    /**
     * 属性值
     */
    private String value;


    /**
     * 排序
     */
    private Integer sort;

}
