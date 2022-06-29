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
@TableName("li_member_grade")
public class MemberGrade implements Serializable {
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
	private Integer experienceValue;
	/**
	 * 
	 */
	private String gradeImage;
	/**
	 * 
	 */
	private String gradeName;
	/**
	 * 
	 */
	private Boolean isDefault;

}
