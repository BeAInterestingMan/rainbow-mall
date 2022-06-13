package com.rainbow.mall.goods.service.pojo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 *  @Description 商品图片
 *  @author liuhu
 *  @Date 2022/6/9 17:25
 */
@Data
@TableName("li_goods_gallery")
public class GoodsGallery implements Serializable {

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
	 * 商品ID
	 */
	private Long goodsId;
	/**
	 * 是否是默认图片
	 */
	private Integer isDefault;
	/**
	 * 原图路径
	 */
	private String original;
	/**
	 * 小图路径
	 */
	private String small;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 缩略图路径
	 */
	private String thumbnail;

}
