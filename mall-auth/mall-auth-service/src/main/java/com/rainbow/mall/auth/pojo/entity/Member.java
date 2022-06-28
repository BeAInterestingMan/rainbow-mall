package com.rainbow.mall.auth.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName("li_member")
public class Member implements Serializable {
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
	 * 会员生日
	 */
	private Date birthday;
	/**
	 * 会员状态
	 */
	private Boolean disabled;
	/**
	 * 会员头像
	 */
	private String face;
	/**
	 * 是否开通店铺
	 */
	private Boolean haveStore;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 会员昵称
	 */
	private String nickName;
	/**
	 * 会员密码
	 */
	private String password;
	/**
	 * 积分数量
	 */
	private Long point;
	/**
	 * 会员性别
	 */
	private Integer sex;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 会员用户名
	 */
	private String username;
	/**
	 * 会员地址
	 */
	private String region;
	/**
	 * 会员地址ID
	 */
	private String regionId;
	/**
	 * 客户端
	 */
	private String clientEnum;
	/**
	 * 最后一次登录时间
	 */
	private Date lastLoginDate;
	/**
	 * 
	 */
	private String gradeid;
	/**
	 * 
	 */
	private Long experience;
	/**
	 * 
	 */
	private Long gradeId;
	/**
	 * 积分总数量
	 */
	private Long totalPoint;

}
