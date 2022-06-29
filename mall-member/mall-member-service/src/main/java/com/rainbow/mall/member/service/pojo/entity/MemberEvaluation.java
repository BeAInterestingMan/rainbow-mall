package com.rainbow.mall.member.service.pojo.entity;

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
@TableName("li_member_evaluation")
public class MemberEvaluation implements Serializable {
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
	 * 评价内容
	 */
	private String content;
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
	 * 好中差评
	 */
	private String grade;
	/**
	 * 评价是否有图片
	 */
	private Boolean haveImage;
	/**
	 * 回复是否有图片
	 */
	private Boolean haveReplyImage;
	/**
	 * 评价图片
	 */
	private String images;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 会员头像
	 */
	private String memberProfile;
	/**
	 * 订单号
	 */
	private String orderNo;
	/**
	 * 评价回复
	 */
	private String reply;
	/**
	 * 评价回复图片
	 */
	private String replyImage;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 货品ID
	 */
	private Long skuId;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 回复状态
	 */
	private Boolean replyStatus;
	/**
	 * 物流评分
	 */
	private Integer deliveryScore;
	/**
	 * 描述评分
	 */
	private Integer descriptionScore;
	/**
	 * 服务评分
	 */
	private Integer serviceScore;
	/**
	 * 店铺名称
	 */
	private String storeName;

}
