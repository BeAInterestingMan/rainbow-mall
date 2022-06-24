package com.rainbow.mall.order.service.pojo.entity;

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
@TableName("li_order_log")
public class OrderLog implements Serializable {
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
	 * 日志信息
	 */
	private String message;
	/**
	 * 操作者ID
	 */
	private Long operatorId;
	/**
	 * 操作者名称
	 */
	private String operatorName;
	/**
	 * 操作者类型
	 */
	private String operatorType;
	/**
	 * 订单编号
	 */
	private String orderSn;

}
