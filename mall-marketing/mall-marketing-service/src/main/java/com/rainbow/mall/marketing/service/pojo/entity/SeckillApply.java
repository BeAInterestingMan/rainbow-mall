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
@TableName("li_seckill_apply")
public class SeckillApply implements Serializable {
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
	 * 驳回原因
	 */
	private String failReason;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品原始价格
	 */
	private Double originalPrice;
	/**
	 * 价格
	 */
	private Double price;
	/**
	 * 促销活动申请状态
	 */
	private String promotionApplyStatus;
	/**
	 * 促销数量
	 */
	private Integer quantity;
	/**
	 * 已售数量
	 */
	private Integer salesNum;
	/**
	 * 活动ID
	 */
	private Long seckillId;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 店铺名称
	 */
	private String storeName;
	/**
	 * 货品ID
	 */
	private Long skuId;
	/**
	 * 时刻
	 */
	private Integer timeLine;

}
