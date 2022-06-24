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
@TableName("li_order_complaint_communication")
public class OrderComplaintCommunication implements Serializable {
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
	 * 投诉ID
	 */
	private Long complainId;
	/**
	 * 对话内容
	 */
	private String content;
	/**
	 * 所属，买家/卖家
	 */
	private String owner;
	/**
	 * 对话所属ID,卖家ID/买家ID
	 */
	private Long ownerId;
	/**
	 * 对话所属名称
	 */
	private String ownerName;

}
