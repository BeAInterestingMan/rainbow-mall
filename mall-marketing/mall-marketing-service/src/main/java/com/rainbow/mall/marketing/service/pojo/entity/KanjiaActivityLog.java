package com.rainbow.mall.marketing.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
@TableName("li_kanjia_activity_log")
public class KanjiaActivityLog implements Serializable {
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
	private Long kanjiaActivityId;
	/**
	 * 
	 */
	private String kanjiaMemberFace;
	/**
	 * 
	 */
	private Long kanjiaMemberId;
	/**
	 * 
	 */
	private String kanjiaMemberName;
	/**
	 * 
	 */
	private Double kanjiaPrice;
	/**
	 * 
	 */
	private Double surplusPrice;

}
