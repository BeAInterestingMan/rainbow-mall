package com.rainbow.mall.goods.service.pojo.dto.service;

import lombok.Data;

import java.util.List;

@Data
public class QueryGoodsSkuListDTO {

    private String categoryId;

    /**品牌,可以多选 品牌*/
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

    private String sn;

    private Integer currentPage = 1;

    private Integer pageSize =10;

    /**排序字段*/
    private String sort;

    /**排序方式 asc/desc*/
    private String order;
}
