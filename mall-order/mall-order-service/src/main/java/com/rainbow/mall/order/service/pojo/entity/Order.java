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
@TableName("li_order")
public class Order implements Serializable {
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
	 * 订单是否支持原路退回
	 */
	private Boolean canReturn;
	/**
	 * 订单取消原因
	 */
	private String cancelReason;
	/**
	 * 订单来源
	 */
	private String clientType;
	/**
	 * 完成时间
	 */
	private Date completeTime;
	/**
	 * 地址id NULL,NULL分割
	 */
	private String consigneeAddressIdPath;
	/**
	 * 地址名称  NULL,NULL分割"
	 */
	private String consigneeAddressPath;
	/**
	 * 详细地址
	 */
	private String consigneeDetail;
	/**
	 * 收件人手机
	 */
	private String consigneeMobile;
	/**
	 * 收件人姓名
	 */
	private String consigneeName;
	/**
	 * 货运状态
	 */
	private String deliverStatus;
	/**
	 * 优惠的金额
	 */
	private Double discountPrice;
	/**
	 * 总价格
	 */
	private Double flowPrice;
	/**
	 * 运费
	 */
	private Double freightPrice;
	/**
	 * 商品数量
	 */
	private Integer goodsNum;
	/**
	 * 商品价格
	 */
	private Double goodsPrice;
	/**
	 * 物流公司CODE
	 */
	private String logisticsCode;
	/**
	 * 物流公司名称
	 */
	private String logisticsName;
	/**
	 * 发货单号
	 */
	private String logisticsNo;
	/**
	 * 送货时间
	 */
	private Date logisticsTime;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 用户名
	 */
	private String memberName;
	/**
	 * 是否需要发票
	 */
	private Boolean needReceipt;
	/**
	 * 订单状态
	 */
	private String orderStatus;
	/**
	 * 订单类型
	 */
	private String orderType;
	/**
	 * 是否为其他订单下的订单，如果是则为依赖订单的sn，否则为空
	 */
	private String parentOrderSn;
	/**
	 * 支付方式返回的交易号
	 */
	private String payOrderNo;
	/**
	 * 付款状态
	 */
	private String payStatus;
	/**
	 * 支付方式
	 */
	private String paymentMethod;
	/**
	 * 支付时间
	 */
	private Date paymentTime;
	/**
	 * 价格详情
	 */
	private String priceDetail;
	/**
	 * 是否为某订单类型的订单，如果是则为订单类型的id，否则为空
	 */
	private Long promotionId;
	/**
	 * 买家订单备注
	 */
	private String remark;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 店铺名称
	 */
	private String storeName;
	/**
	 * 订单编号
	 */
	private String sn;
	/**
	 * 交易编号 关联Trade
	 */
	private String tradeSn;
	/**
	 * 订单商品总重量
	 */
	private Double weight;
	/**
	 * 提货码
	 */
	private String qrCode;
	/**
	 * 修改价格
	 */
	private Double updatePrice;
	/**
	 * 分销员ID
	 */
	private Long distributionId;
	/**
	 * 配送方式
	 */
	private String deliveryMethod;
	/**
	 * 使用的平台会员优惠券id
	 */
	private Long usePlatformMemberCouponId;
	/**
	 * 使用的店铺会员优惠券id(,区分)
	 */
	private String useStoreMemberCouponIds;
	/**
	 * 
	 */
	private String receivableNo;
	/**
	 * 
	 */
	private String orderPromotionType;
	/**
	 * 
	 */
	private String verificationCode;

}
