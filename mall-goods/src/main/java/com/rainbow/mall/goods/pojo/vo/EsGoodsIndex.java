package com.rainbow.mall.goods.pojo.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class EsGoodsIndex implements Serializable {

    private static final long serialVersionUID = -6856471777036048874L;

    @ApiModelProperty("商品skuId")
    private String id;

    /**
     * 商品id
     */
    @ApiModelProperty("商品Id")
    private String goodsId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String goodsName;

    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    private String sn;

    /**
     * 卖家id
     */
    @ApiModelProperty("卖家id")
    private String storeId;

    /**
     * 卖家名称
     */
    @ApiModelProperty("卖家名称")
    private String storeName;

    /**
     * 销量
     */

    @ApiModelProperty("销量")
    private Integer buyCount;

    /**
     * 小图
     */
    @ApiModelProperty("小图")
    private String small;

    /**
     * 缩略图
     */
    @ApiModelProperty("缩略图")
    private String thumbnail;

    /**
     * 品牌id
     */
    @ApiModelProperty("品牌id")
    private String brandId;

    /**
     * 品牌名称
     */
    @ApiModelProperty("品牌名称")
    private String brandName;

    /**
     * 品牌图片地址
     */
    @ApiModelProperty("品牌图片地址")
    private String brandUrl;

    /**
     * 分类path
     */
    @ApiModelProperty("分类path")
    private String categoryPath;

    /**
     * 分类名称path
     */
    @ApiModelProperty("分类名称path")
    private String categoryNamePath;

    /**
     * 店铺分类id
     */
    @ApiModelProperty("店铺分类id")
    private String storeCategoryPath;

    /**
     * 店铺分类名称
     */
    @ApiModelProperty("店铺分类名称")
    private String storeCategoryNamePath;

    /**
     * 商品价格
     */
    @ApiModelProperty("商品价格")
    private Double price;

    /**
     * 促销价
     */
    @ApiModelProperty("促销价")
    private Double promotionPrice;

    /**
     * 如果是积分商品需要使用的积分
     */
    @ApiModelProperty("积分商品需要使用的积分")
    private Integer point;

    /**
     * 评价数量
     */
    @ApiModelProperty("评价数量")
    private Integer commentNum;

    /**
     * 好评数量
     */
    @ApiModelProperty("好评数量")
    private Integer highPraiseNum;

    /**
     * 好评率
     */
    @ApiModelProperty("好评率")
    private Double grade;

    /**
     * 详情
     */
    @ApiModelProperty("详情")
    private String intro;

    /**
     * 商品移动端详情
     */
    @ApiModelProperty("商品移动端详情")
    private String mobileIntro;

    /**
     * 是否自营
     */
    @ApiModelProperty("是否自营")
    private Boolean selfOperated;

    /**
     * 是否为推荐商品
     */
    @ApiModelProperty("是否为推荐商品")
    private Boolean recommend;

    /**
     * 销售模式
     */
    @ApiModelProperty("销售模式")
    private String salesModel;

    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String authFlag;

    /**
     * 卖点
     */
    @ApiModelProperty("卖点")
    private String sellingPoint;

    /**
     * 上架状态
     */
    @ApiModelProperty("上架状态")
    private String marketEnable;

    /**
     * 商品视频
     */
    @ApiModelProperty("商品视频")
    private String goodsVideo;

    @ApiModelProperty("商品发布时间")
    private Long releaseTime;

    /**
     */
    @ApiModelProperty(value = "商品类型", required = true)
    private String goodsType;

    @ApiModelProperty(value = "商品sku基础分数", required = true)
    private Integer skuSource;

    /**
     * 商品属性（参数和规格）
     */
    private List<EsGoodsAttribute> attrList;

    @ApiModelProperty("商品促销活动集合JSON，key 为 促销活动类型，value 为 促销活动实体信息 ")
    private String promotionMapJson;


}
