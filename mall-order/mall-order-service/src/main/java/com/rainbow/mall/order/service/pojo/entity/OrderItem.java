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
@TableName("li_order_item")
public class OrderItem implements Serializable {
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
	 * 售后状态
	 */
	private String afterSaleStatus;
	/**
	 * 分类ID
	 */
	private Long categoryId;
	/**
	 * 评论状态
	 */
	private String commentStatus;
	/**
	 * 交易投诉ID
	 */
	private Long complainId;
	/**
	 * 投诉状态
	 */
	private String complainStatus;
	/**
	 * 实际金额
	 */
	private Double flowPrice;
	/**
	 * 销售金额
	 */
	private Double goodsPrice;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 图片
	 */
	private String image;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 销售量
	 */
	private Integer num;
	/**
	 * 订单编号
	 */
	private String orderSn;
	/**
	 * 价格详情
	 */
	private String priceDetail;
	/**
	 * 促销ID
	 */
	private Long promotionId;
	/**
	 * 促销类型
	 */
	private String promotionType;
	/**
	 * 货品ID
	 */
	private Long skuId;
	/**
	 * 子订单编号
	 */
	private String sn;
	/**
	 * 快照ID
	 */
	private Long snapshotId;
	/**
	 * 规格json
	 */
	private String specs;
	/**
	 * 交易编号
	 */
	private String tradeSn;
	/**
	 * 浮动价格比例
	 */
	private Double priceFluctuationRatio;
	/**
	 * 单价
	 */
	private Double unitPrice;
	/**
	 * 小记
	 */
	private Double subTotal;
	/**
	 * 退货数量 
	 */
	private Integer returnGoodsNumber;

}
