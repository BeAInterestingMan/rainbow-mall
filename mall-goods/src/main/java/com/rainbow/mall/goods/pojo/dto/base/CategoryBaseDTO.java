package com.rainbow.mall.goods.pojo.dto.base;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class CategoryBaseDTO implements Serializable {

    /**
     * 创建者
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 删除标志 true/false 删除/未删除
     */
    private Boolean deleteFlag;
    /**
     * 更新者
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 佣金比例
     */
    private BigDecimal commissionRate;
    /**
     * 分类图标
     */
    private String image;
    /**
     * 层级
     */
    private Integer level;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 父ID
     */
    private Long parentId;
    /**
     * 排序值
     */
    private Integer sortOrder;
    /**
     * 是否支持频道
     */
    private Boolean supportChannel;

    private String id;
}
