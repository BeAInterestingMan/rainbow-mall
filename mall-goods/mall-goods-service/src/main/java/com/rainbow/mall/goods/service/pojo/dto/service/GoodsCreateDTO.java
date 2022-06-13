package com.rainbow.mall.goods.service.pojo.dto.service;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Data
@ApiModel("pc后台商家商品新增")
public class GoodsCreateDTO implements Serializable {

    private static final long serialVersionUID = -509667581371776913L;

    @ApiModelProperty(hidden = true)
    private String goodsId;

    @ApiModelProperty(value = "商品价格", required = true)
    @NotNull(message = "商品价格不能为空")
    @Min(value = 0, message = "商品价格不能为负数")
    @Max(value = 99999999, message = "商品价格不能超过99999999")
    private Double price;

    @ApiModelProperty(value = "分类path")
    private String categoryPath;

    @ApiModelProperty(value = "店铺分类id", required = true)
    @Size(max = 200, message = "选择了太多店铺分类")
    private String storeCategoryPath;

    @ApiModelProperty(value = "品牌id")
    @Min(value = 0, message = "品牌值不正确")
    private String brandId;

    @ApiModelProperty(value = "商品名称", required = true)
    @NotEmpty(message = "商品名称不能为空")
    @Length(max = 50, message = "商品名称不能超过50个字符")
    private String goodsName;

    @ApiModelProperty(value = "详情")
    private String intro;

    @ApiModelProperty(value = "商品移动端详情")
    private String mobileIntro;

    @ApiModelProperty(value = "库存")
    @Min(value = 0, message = "库存不能为负数")
    @Max(value = 99999999, message = "库存不能超过99999999")
    private Integer quantity;

    @ApiModelProperty(value = "是否立即发布")
    private Boolean release;

    @ApiModelProperty(value = "是否是推荐商品")
    private Boolean recommend;

    @ApiModelProperty(value = "商品参数")
    private List<GoodsParamsDTO> goodsParamsDTOList;

    @ApiModelProperty(value = "商品图片")
    private List<String> goodsGalleryList;

    @ApiModelProperty(value = "运费模板id,不需要运费模板时值是0", required = true)
    @NotNull(message = "运费模板不能为空，没有运费模板时，传值0")
    @Min(value = 0, message = "运费模板值不正确")
    private String templateId;

    @ApiModelProperty(value = "卖点")
    private String sellingPoint;


    @ApiModelProperty(value = "销售模式", required = true)
    private String salesModel;

//    @ApiModelProperty(value = "是否有规格", hidden = true)
//    private String haveSpec;

    @ApiModelProperty(value = "销售模式", required = true)
    private String goodsUnit;

    @ApiModelProperty(value = "商品描述")
    private String info;

//    @ApiModelProperty(value = "是否重新生成sku数据")
//    private Boolean regeneratorSkuFlag = true;

    @ApiModelProperty(value = "商品类型")
    private String goodsType;
//    /**
//     * 商品视频
//     */
//    @ApiModelProperty(value = "商品视频")
//    private String goodsVideo;


    @ApiModelProperty(value = "sku列表")
    @Valid
    private List<Map<String, Object>> skuList;

//    /**
//     * 批发商品规则
//     */
//    @ApiModelProperty(value = "批发商品规则")
//    private List<WholesaleDTO> wholesaleList;

}
