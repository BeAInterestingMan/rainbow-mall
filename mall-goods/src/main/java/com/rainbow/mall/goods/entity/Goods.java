package com.rainbow.mall.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 *  @Description 商品
 *  @author liuhu
 *  @Date 2022/6/9 17:24
 */
@Data
@TableName("li_goods")
public class Goods implements Serializable {

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
	 * 审核信息
	 */
	private String authMessage;
	/**
	 * 品牌ID
	 */
	private Long brandId;
	/**
	 * 购买数量
	 */
	private Integer buyCount;
	/**
	 * 分类路径
	 */
	private String categoryPath;
	/**
	 * 评论数量
	 */
	private Integer commentNum;
	/**
	 * 成本价格
	 */
	private Double cost;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 计量单位
	 */
	private String goodsUnit;
	/**
	 * 商品视频
	 */
	private String goodsVideo;
	/**
	 * 商品好评率
	 */
	private Double grade;
	/**
	 * 商品详情
	 */
	private String intro;
	/**
	 * 审核状态
	 */
	private String authFlag;
	/**
	 * 上架状态
	 */
	private String marketEnable;
	/**
	 * 商品移动端详情
	 */
	private String mobileIntro;
	/**
	 * 原图路径
	 */
	private String original;
	/**
	 * 商品价格
	 */
	private Double price;
	/**
	 * 库存
	 */
	private Integer quantity;
	/**
	 * 是否为推荐商品
	 */
	private Boolean recommend;
	/**
	 * 销售模式
	 */
	private String salesModel;
	/**
	 * 是否自营
	 */
	private Boolean selfOperated;
	/**
	 * 店铺ID
	 */
	private Long storeId;
	/**
	 * 店铺名称
	 */
	private String storeName;
	/**
	 * 卖点
	 */
	private String sellingPoint;
	/**
	 * 店铺分类
	 */
	private String shopCategoryPath;
	/**
	 * 小图路径
	 */
	private String small;
	/**
	 * 商品编号
	 */
	private String sn;
	/**
	 * 运费模板ID
	 */
	private Long templateId;
	/**
	 * 缩略图路径
	 */
	private String thumbnail;
	/**
	 * 下架原因
	 */
	private String underMessage;
	/**
	 * 重量
	 */
	private Double weight;
	/**
	 * 店铺分类路径
	 */
	private String storeCategoryPath;
	/**
	 * 大图路径
	 */
	private String big;
	/**
	 * 
	 */
	private String params;
	/**
	 * 
	 */
	private String goodsType;

}
