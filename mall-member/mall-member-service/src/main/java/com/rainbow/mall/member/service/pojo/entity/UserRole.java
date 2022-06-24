package com.rainbow.mall.member.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.Data;


@Data
@TableName("li_user_role")
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 角色唯一id
	 */
	private Long roleId;
	/**
	 * 用户唯一id
	 */
	private Long userId;

}
