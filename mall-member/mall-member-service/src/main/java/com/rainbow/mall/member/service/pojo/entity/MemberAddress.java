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
@TableName("li_member_address")
public class MemberAddress implements Serializable {
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
	 * 地址别名
	 */
	private String alias;
	/**
	 * 地址ID
	 */
	private String consigneeAddressIdPath;
	/**
	 * 地址名称
	 */
	private String consigneeAddressPath;
	/**
	 * 详细地址
	 */
	private String detail;
	/**
	 * 是否为默认收货地址
	 */
	private Boolean isDefault;
	/**
	 * 纬度
	 */
	private String lat;
	/**
	 * 经度
	 */
	private String lon;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 收货人姓名
	 */
	private String name;

}
