package com.rainbow.mall.marketing.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_full_discount")
public class FullDiscount implements Serializable {
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
	 * 优惠券ID
	 */
	private Long couponId;
	/**
	 * 活动说明
	 */
	private String description;
	/**
	 * 减现金
	 */
	private Double fullMinus;
	/**
	 * 优惠门槛金额
	 */
	private Double fullMoney;
	/**
	 * 打折
	 */
	private Double fullRate;
	/**
	 * 赠品ID
	 */
	private Long giftId;
	/**
	 * 是否赠优惠券
	 */
	private Boolean couponFlag;
	/**
	 * 是否包邮
	 */
	private Boolean freeFreightFlag;
	/**
	 * 活动是否减现金
	 */
	private Boolean fullMinusFlag;
	/**
	 * 是否打折
	 */
	private Boolean fullRateFlag;
	/**
	 * 是否有赠品
	 */
	private Boolean giftFlag;
	/**
	 * 是否赠送积分
	 */
	private Boolean pointFlag;
	/**
	 * 赠送多少积分
	 */
	private Integer point;
	/**
	 * 活动标题
	 */
	private String title;

}
