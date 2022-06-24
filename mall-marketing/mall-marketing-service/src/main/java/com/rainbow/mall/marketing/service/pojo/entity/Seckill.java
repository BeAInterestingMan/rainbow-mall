package com.rainbow.mall.marketing.service.pojo.entity;

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
 * @date 2022-06-09 19:19:49
 */
@Data
@TableName("li_seckill")
public class Seckill implements Serializable {
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
	 * 活动结束时间
	 */
	private Date endTime;
	/**
	 * 活动名称
	 */
	private String promotionName;
	/**
	 * 范围关联的ID
	 */
	private String scopeId;
	/**
	 * 关联范围类型
	 */
	private String scopeType;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 店铺名称
	 */
	private String storeName;
	/**
	 * 活动开始时间
	 */
	private Date startTime;
	/**
	 * 报名截至时间
	 */
	private Date applyEndTime;
	/**
	 * 开启几点场
	 */
	private String hours;
	/**
	 * 申请规则
	 */
	private String seckillRule;
	/**
	 * 店铺ID集合以逗号分隔
	 */
	private String storeIds;
	/**
	 * 
	 */
	private Integer goodsNum;

}
