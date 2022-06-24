package com.rainbow.mall.marketing.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_kanjia_activity")
public class KanjiaActivity implements Serializable {
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
	private String goodsName;
	/**
	 * 
	 */
	private Long kanjiaActivityGoodsId;
	/**
	 * 
	 */
	private Long memberId;
	/**
	 * 
	 */
	private String memberName;
	/**
	 * 
	 */
	private Double purchasePrice;
	/**
	 * 
	 */
	private Long skuId;
	/**
	 * 
	 */
	private String status;
	/**
	 * 
	 */
	private Double surplusPrice;
	/**
	 * 
	 */
	private String thumbnail;

}
