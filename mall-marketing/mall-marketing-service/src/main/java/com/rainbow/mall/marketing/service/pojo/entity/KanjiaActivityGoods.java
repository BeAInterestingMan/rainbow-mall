package com.rainbow.mall.marketing.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_kanjia_activity_goods")
public class KanjiaActivityGoods implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 
	 */
	private String createBy;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Boolean deleteFlag;
	/**
	 * 
	 */
	private String updateBy;
	/**
	 * 
	 */
	private Date updateTime;
	/**
	 * 
	 */
	private Date endTime;
	/**
	 * 
	 */
	private String promotionName;
	/**
	 * 范围关联的ID
	 */
	private String scopeId;
	/**
	 * 
	 */
	private String scopeType;
	/**
	 * 
	 */
	private Date startTime;
	/**
	 * 
	 */
	private Long storeId;
	/**
	 * 
	 */
	private String storeName;
	/**
	 * 
	 */
	private String goodsName;
	/**
	 * 
	 */
	private Double highestPrice;
	/**
	 * 
	 */
	private Double lowestPrice;
	/**
	 * 
	 */
	private Double originalPrice;
	/**
	 * 
	 */
	private Double purchasePrice;
	/**
	 * 
	 */
	private Double settlementPrice;
	/**
	 * 
	 */
	private Long goodsId;
	/**
	 * 
	 */
	private Long skuId;
	/**
	 * 
	 */
	private Integer stock;
	/**
	 * 
	 */
	private String thumbnail;

}
