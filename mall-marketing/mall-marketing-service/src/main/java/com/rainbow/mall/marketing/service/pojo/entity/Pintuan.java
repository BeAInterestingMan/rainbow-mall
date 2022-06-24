package com.rainbow.mall.marketing.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_pintuan")
public class Pintuan implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
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
	 * 活动结束时间
	 */
	private Date endTime;
	/**
	 * 活动名称
	 */
	private String promotionName;
	/**
	 * 范围关联的ID
	 */
	private String scopeId;
	/**
	 * 关联范围类型
	 */
	private String scopeType;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 店铺名称
	 */
	private String storeName;
	/**
	 * 活动开始时间
	 */
	private Date startTime;
	/**
	 * 虚拟成团
	 */
	private Boolean fictitious;
	/**
	 * 限购数量
	 */
	private Integer limitNum;
	/**
	 * 拼团规则
	 */
	private String pintuanRule;
	/**
	 * 成团人数
	 */
	private Integer requiredNum;

}
