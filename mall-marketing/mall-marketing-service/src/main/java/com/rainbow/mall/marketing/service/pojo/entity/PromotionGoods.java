package com.rainbow.mall.marketing.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_promotion_goods")
public class PromotionGoods implements Serializable {
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
	 * 货品名称
	 */
	private String goodsName;
	/**
	 * 限购数量
	 */
	private Integer limitNum;
	/**
	 * 卖出的商品数量
	 */
	private Integer num;
	/**
	 * 原价
	 */
	private Double originalPrice;
	/**
	 * 促销价格
	 */
	private Double price;
	/**
	 * 范围关联的ID
	 */
	private String scopeId;
	/**
	 * 关联范围类型
	 */
	private String scopeType;
	/**
	 * 活动ID
	 */
	private Long promotionId;
	/**
	 * 促销库存
	 */
	private Integer quantity;
	/**
	 * 兑换积分
	 */
	private String points;
	/**
	 * 促销工具类型
	 */
	private String promotionType;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 店铺名称
	 */
	private String storeName;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 货品SkuID
	 */
	private Long skuId;
	/**
	 * 活动开始时间
	 */
	private Date startTime;
	/**
	 * 缩略图
	 */
	private String thumbnail;
	/**
	 * 活动标题
	 */
	private String title;
	/**
	 * 分类路径
	 */
	private String categoryPath;
	/**
	 * 
	 */
	private String goodsType;

}
