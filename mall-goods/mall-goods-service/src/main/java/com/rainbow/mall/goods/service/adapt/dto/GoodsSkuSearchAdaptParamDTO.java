package com.rainbow.mall.goods.service.adapt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("商品搜索入参")
public class GoodsSkuSearchAdaptParamDTO {

    /**关键字*/
    private String keyword;

    /**分类*/
    private String categoryId;

    /**品牌,可以多选 品牌Id@品牌Id@品牌Id*/
    private String brandId;

    /**是否为推荐商品*/
    private Boolean recommend;

    /**价格*/
    private String price;

/**属性:参数名_参数值@参数名_参数值*/
    private String prop;

 /**规格项列表*/
    private List<String> nameIds;

    /**卖家id，搜索店铺商品的时候使用*/
    private String storeId;

    /**商家分组id，搜索店铺商品的时候使用*/
    private String storeCatId;

    /**当前商品skuId,根据当前浏览的商品信息来给用户推荐可能喜欢的商品*/
    private String currentGoodsId;

    /**当前页*/
    private Integer currentPage = 1;

    /**页面数据*/
    private Integer pageSize = 10;

    /**排序字段*/
    private String sort;

    /**排序方式 asc/desc*/
    private String order;
}
