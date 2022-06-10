package com.rainbow.mall.cms.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("li_page_data")
public class PageData implements Serializable {

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
	 * 页面名称
	 */
	private String name;
	/**
	 * 值
	 */
	private String num;
	/**
	 * 客户端类型
	 */
	private String pageClientType;
	/**
	 * 页面数据
	 */
	private String pageData;
	/**
	 * 页面开关状态
	 */
	private String pageShow;
	/**
	 * 页面类型
	 */
	private String pageType;

}
