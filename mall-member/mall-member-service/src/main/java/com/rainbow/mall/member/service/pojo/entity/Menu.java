package com.rainbow.mall.member.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_menu")
public class Menu implements Serializable {
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
	 * 说明备注
	 */
	private String description;
	/**
	 * 前端路由
	 */
	private String frontRoute;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 层级
	 */
	private Integer level;
	/**
	 * 菜单/权限名称
	 */
	private String name;
	/**
	 * 父id
	 */
	private Long parentId;
	/**
	 * 赋权API地址,正则表达式
	 */
	private String path;
	/**
	 * 排序值
	 */
	private BigDecimal sortOrder;
	/**
	 * 菜单标题
	 */
	private String title;
	/**
	 * 文件地址
	 */
	private String frontComponent;
	/**
	 * 权限url
	 */
	private String permission;

}
