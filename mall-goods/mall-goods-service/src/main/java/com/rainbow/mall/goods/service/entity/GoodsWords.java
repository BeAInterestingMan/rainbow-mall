package com.rainbow.mall.goods.service.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2022-06-09 17:16:36
 */
@Data
@TableName("li_goods_words")
public class GoodsWords implements Serializable {

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
	private String abbreviate;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String wholeSpell;
	/**
	 * 
	 */
	private String words;

}
