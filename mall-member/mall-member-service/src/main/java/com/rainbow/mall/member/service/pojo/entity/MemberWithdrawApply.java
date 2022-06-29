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
@TableName("li_member_withdraw_apply")
public class MemberWithdrawApply implements Serializable {
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
	 * 申请提现金额
	 */
	private Double applyMoney;
	/**
	 * 提现状态
	 */
	private String applyStatus;
	/**
	 * 审核备注
	 */
	private String inspectRemark;
	/**
	 * 审核时间
	 */
	private Date inspectTime;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 编号
	 */
	private String sn;

}
