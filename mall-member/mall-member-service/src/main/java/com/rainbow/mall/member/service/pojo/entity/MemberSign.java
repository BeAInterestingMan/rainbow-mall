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
@TableName("li_member_sign")
public class MemberSign implements Serializable {
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
	 * 会员用户ID
	 */
	private Long memberId;
	/**
	 * 会员用户名
	 */
	private String memberName;
	/**
	 * 连续签到天数
	 */
	private Integer signDay;
	/**
	 * 签到日 
	 */
	private Integer day;

}
