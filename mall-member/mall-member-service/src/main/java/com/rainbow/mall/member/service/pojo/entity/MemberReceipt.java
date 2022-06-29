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
@TableName("li_member_receipt")
public class MemberReceipt implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 删除标志 true/false 删除/未删除
	 */
	private Boolean deleteFlag;
	/**
	 * 是否为默认选项
	 */
	private Integer isDefault;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 发票内容
	 */
	private String receiptContent;
	/**
	 * 发票抬头
	 */
	private String receiptTitle;
	/**
	 * 发票类型
	 */
	private String receiptType;
	/**
	 * 纳税人识别号
	 */
	private String taxpayerId;

}
