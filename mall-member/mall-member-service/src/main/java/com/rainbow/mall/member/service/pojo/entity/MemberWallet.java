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
@TableName("li_member_wallet")
public class MemberWallet implements Serializable {
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
	 * 删除标志
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
	 * 会员预存款冻结金额
	 */
	private Double memberFrozenWallet;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员用户名
	 */
	private String memberName;
	/**
	 * 会员预存款
	 */
	private Double memberWallet;
	/**
	 * 预存款密码
	 */
	private String walletPassword;

}
