package com.rainbow.mall.goods.service.pojo.dto.service;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品索引
 **/
@Data
public class QuerySkuListGoodsBaseDTO implements Serializable {

    /**商品skuId*/
    private String id;

    /**
     * 商品id
     */
    private String goodsId;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品编号
     */
    private String sn;

    /**
     * 卖家id
     */
    private String storeId;

    /**
     * 卖家名称
     */
    private String storeName;

    /**
     * 销量
     */

    private Integer buyCount;

    /**
     * 小图
     */
    private String small;

    /**
     * 缩略图
     */
    private String thumbnail;

    /**
     * 品牌id
     */
    private String brandId;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌图片地址
     */
    private String brandUrl;

    /**
     * 分类path
     */
    private String categoryPath;

    /**
     * 分类名称path
     */
    private String categoryNamePath;

    /**
     * 店铺分类id
     */
    private String storeCategoryPath;

    /**
     * 店铺分类名称
     */
    private String storeCategoryNamePath;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 促销价
     */
    private Double promotionPrice;

    /**
     * 如果是积分商品需要使用的积分
     */
    private Integer point;

    /**
     * 评价数量
     */
    private Integer commentNum;

    /**
     * 好评数量
     */
    private Integer highPraiseNum;

    /**
     * 好评率
     */
    private Double grade;

    /**
     * 详情
     */
    private String intro;

    /**
     * 商品移动端详情
     */
    private String mobileIntro;

    /**
     * 是否自营
     */
    private Boolean selfOperated;

    /**
     * 是否为推荐商品
     */
    private Boolean recommend;

    /**
     * 销售模式
     */
    private String salesModel;

    /**
     * 审核状态
     */
    private String authFlag;

    /**
     * 卖点
     */
    private String sellingPoint;

    /**
     * 上架状态
     */
    private String marketEnable;

    /**
     * 商品视频
     */
    private String goodsVideo;

    /**商品发布时间*/
    private Long releaseTime;

    /**商品类型*/
    private String goodsType;

    /**商品sku基础分数*/
    private Integer skuSource;
//    /**
//     * 商品属性（参数和规格）
//     */
//    private List<EsGoodsAttribute> attrList;

    /**
     * 商品促销活动集合
     */
    private String promotionMapJson;

}
