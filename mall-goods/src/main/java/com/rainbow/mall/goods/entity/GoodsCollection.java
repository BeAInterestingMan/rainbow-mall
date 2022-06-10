package com.rainbow.mall.goods.entity;

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
@TableName("li_goods_collection")
public class GoodsCollection implements Serializable {

	/**
	 * ID
	 */
	@TableId
	private Long id;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 会员id
	 */
	private Long memberId;
	/**
	 * 商品id
	 */
	private Long skuId;

}
