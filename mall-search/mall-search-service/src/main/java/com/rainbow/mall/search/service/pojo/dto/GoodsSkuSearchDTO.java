package com.rainbow.mall.search.service.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@FieldNameConstants
public class GoodsSkuSearchDTO {

    @ApiModelProperty(value = "关键字")
    private String keyword;

    private String categoryId;

    /**品牌,可以多选 品牌*/
    private String brandId;

    /**是否为推荐商品*/
    private Boolean recommend;

    /**价格*/
    private String price;

   /**属性:参数名_参数值@参数名_参数值*/
    private String prop;

    @ApiModelProperty(value = "规格项列表")
    private List<String> nameIds;

    @ApiModelProperty(value = "卖家id，搜索店铺商品的时候使用")
    private String storeId;

    @ApiModelProperty(value = "商家分组id，搜索店铺商品的时候使用")
    private String storeCatId;

    private String sn;

    @ApiModelProperty(value = "页号")
    private Integer currentPage = 1;

    @ApiModelProperty(value = "页面大小")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "排序字段")
    private String sort;

    @ApiModelProperty(value = "排序方式 asc/desc")
    private String order;
}
