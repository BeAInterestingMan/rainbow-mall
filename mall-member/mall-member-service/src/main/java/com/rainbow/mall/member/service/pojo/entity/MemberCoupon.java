package com.rainbow.mall.member.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-06-09 19:19:50
 */
@Data
@TableName("li_member_coupon")
public class MemberCoupon implements Serializable {
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
	 * 消费门槛
	 */
	private Double consumeThreshold;
	/**
	 * 核销时间
	 */
	private Date consumptionTime;
	/**
	 * 优惠券ID
	 */
	private Long couponId;
	/**
	 * 活动类型
	 */
	private String couponType;
	/**
	 * 折扣
	 */
	private Double discount;
	/**
	 * 使用截止时间
	 */
	private Date endTime;
	/**
	 * 优惠券类型
	 */
	private String getType;
	/**
	 * 是否是平台优惠券
	 */
	private Boolean platformFlag;
	/**
	 * 会员优惠券状态
	 */
	private String memberCouponStatus;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 面额
	 */
	private Double price;
	/**
	 * 范围关联的ID
	 */
	private String scopeId;
	/**
	 * 关联范围类型
	 */
	private String scopeType;
	/**
	 * 店铺承担比例
	 */
	private Double storeCommission;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 使用起始时间
	 */
	private Date startTime;
	/**
	 * 店铺名称
	 */
	private String storeName;

}
