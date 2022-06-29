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
@TableName("li_member_points_history")
public class MemberPointsHistory implements Serializable {
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
	 * 消费之前积分
	 */
	private Long beforePoint;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 会员ID
	 */
	private Long memberId;
	/**
	 * 会员名称
	 */
	private String memberName;
	/**
	 * 当前积分
	 */
	private Long point;
	/**
	 * 消费积分类型
	 */
	private String pointType;
	/**
	 * 消费积分
	 */
	private Long variablePoint;

}
