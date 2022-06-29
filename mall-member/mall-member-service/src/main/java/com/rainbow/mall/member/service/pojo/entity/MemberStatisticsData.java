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
@TableName("li_member_statistics_data")
public class MemberStatisticsData implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 当日活跃数量
	 */
	private Integer activeQuantity;
	/**
	 * 统计日
	 */
	private Date createDate;
	/**
	 * 当前会员数量
	 */
	private Integer memberCount;
	/**
	 * 新增会员数量
	 */
	private Integer newlyAdded;

}
