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
@TableName("li_order_complaint")
public class OrderComplaint implements Serializable {
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
	 * 申诉商家内容
	 */
	private String appealContent;
	/**
	 * 申诉商家上传的图片
	 */
	private String appealImages;
	/**
	 * 申诉商家时间
	 */
	private Date appealTime;
	/**
	 * 仲裁结果
	 */
	private String arbitrationResult;
	/**
	 * 交易投诉状态
	 */
	private String complainStatus;
	/**
	 * 投诉主题
	 */
	private String complainTopic;
	/**
	 * 收货地址
	 */
	private String consigneeAddressPath;
	/**
	 * 收货人手机
	 */
	private String consigneeMobile;
	/**
	 * 收货人
	 */
	private String consigneeName;
	/**
	 * 投诉内容
	 */
	private String content;
	/**
	 * 运费
	 */
	private Double freightPrice;
	/**
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 商品图片
	 */
	private String goodsImage;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品价格
	 */
	private Double goodsPrice;
	/**
	 * 投诉凭证图片
	 */
	private String images;
	/**
	 * 物流单号
	 */
	private String logisticsNo;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 购买的商品数量
	 */
	private Integer num;
	/**
	 * 订单金额
	 */
	private Double orderPrice;
	/**
	 * 订单编号
	 */
	private String orderSn;
	/**
	 * 下单时间
	 */
	private Date orderTime;
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

}
