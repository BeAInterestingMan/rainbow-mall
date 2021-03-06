package com.rainbow.mall.goods.service.pojo.dto.base;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class GoodsSkuBaseDTO implements Serializable {

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 大图路径
	 */
	private String big;
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
	 * 评价数量
	 */
	private Integer commentNum;
	/**
	 * 成本价格
	 */
	private BigDecimal cost;
	/**
	 * 运费承担者
	 */
	private String freightPayer;
	/**
	 * 配送模版ID
	 */
	private Long freightTemplateId;
	/**
	 * 商品ID
	 */
	private Long goodsId;
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
	 * 是否是促销商品
	 */
	private Boolean promotionFlag;
	/**
	 * 上架状态
	 */
	private String marketEnable;
	/**
	 * 移动端商品详情
	 */
	private String mobileIntro;
	/**
	 * 原图路径
	 */
	private String original;
	/**
	 * 商品价格
	 */
	private BigDecimal price;
	/**
	 * 促销价
	 */
	private BigDecimal promotionPrice;
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
	 * 小图路径
	 */
	private String small;
	/**
	 * 商品编号
	 */
	private String sn;
	/**
	 * 规格信息json
	 */
	private String specs;
	/**
	 * 运费模板id
	 */
	private Long templateId;
	/**
	 * 缩略图路径
	 */
	private String thumbnail;
	/**
	 * 浏览数量
	 */
	private Integer viewCount;
	/**
	 * 重量
	 */
	private BigDecimal weight;
	/**
	 * 规格信息
	 */
	private String simpleSpecs;
	/**
	 * 店铺分类路径
	 */
	private String storeCategoryPath;
	/**
	 * 
	 */
	private String goodsType;

}
