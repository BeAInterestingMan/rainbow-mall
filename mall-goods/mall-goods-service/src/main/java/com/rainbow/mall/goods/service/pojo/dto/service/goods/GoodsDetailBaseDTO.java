package com.rainbow.mall.goods.service.pojo.dto.service.goods;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rainbow.mall.goods.service.pojo.dto.service.GoodsParamsDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.WholesaleDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Data
public class GoodsDetailBaseDTO implements Serializable {


    @ApiModelProperty(value = "唯一标识", hidden = true)
    private String id;


    @ApiModelProperty(value = "创建者", hidden = true)
    private String createBy;

    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;


    @ApiModelProperty(value = "更新者", hidden = true)
    private String updateBy;


    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "删除标志 true/false 删除/未删除", hidden = true)
    private Boolean deleteFlag;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品价格", required = true)
    private Double price;

    @ApiModelProperty(value = "品牌id")
    private String brandId;

    @ApiModelProperty(value = "分类path")
    private String categoryPath;

    @ApiModelProperty(value = "计量单位")
    private String goodsUnit;

    @Length(max = 60, message = "商品卖点太长，不能超过60个字符")
    @ApiModelProperty(value = "卖点")
    private String sellingPoint;

    @ApiModelProperty(value = "上架状态")
    private String marketEnable;

    @ApiModelProperty(value = "详情")
    private String intro;

    @ApiModelProperty(value = "购买数量")
    private Integer buyCount;

    @Max(value = 99999999, message = "库存不能超过99999999")
    @ApiModelProperty(value = "库存")
    private Integer quantity;

    @ApiModelProperty(value = "商品好评率")
    private Double grade;

    @ApiModelProperty(value = "缩略图路径")
    private String thumbnail;

    @ApiModelProperty(value = "小图路径")
    private String small;

    @ApiModelProperty(value = "原图路径")
    private String original;

    @ApiModelProperty(value = "店铺分类id")
    private String storeCategoryPath;

    @ApiModelProperty(value = "评论数量")
    private Integer commentNum;

    @ApiModelProperty(value = "卖家id")
    private String storeId;

    @ApiModelProperty(value = "卖家名字")
    private String storeName;

    @ApiModelProperty(value = "运费模板id")
    private String templateId;

    @ApiModelProperty(value = "审核状态")
    private String authFlag;

    @ApiModelProperty(value = "审核信息")
    private String authMessage;

    @ApiModelProperty(value = "下架原因")
    private String underMessage;

    @ApiModelProperty(value = "是否自营")
    private Boolean selfOperated;

    @ApiModelProperty(value = "商品移动端详情")
    private String mobileIntro;

    @ApiModelProperty(value = "商品视频")
    private String goodsVideo;

    @ApiModelProperty(value = "是否为推荐商品", required = true)
    private Boolean recommend;

    @ApiModelProperty(value = "销售模式", required = true)
    private String salesModel;

    @ApiModelProperty(value = "商品类型", required = true)
    private String goodsType;

    @ApiModelProperty(value = "商品参数json", hidden = true)
    @JsonIgnore
    private String params;

    @ApiModelProperty(value = "分类名称")
    private List<String> categoryName;

    @ApiModelProperty(value = "商品参数")
    private List<GoodsParamsDTO> goodsParamsDTOList;

    @ApiModelProperty(value = "商品图片")
    private List<String> goodsGalleryList;

    @ApiModelProperty(value = "sku列表")
    private List<GoodsSkuBaseDetailDTO> skuList;

    @ApiModelProperty(value = "批发商品消费规则列表")
    private List<WholesaleDTO> wholesaleList;
}
