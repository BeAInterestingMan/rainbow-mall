package com.rainbow.mall.goods.service.pojo.response;

import com.rainbow.mall.goods.service.pojo.dto.service.WholesaleDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuSpecDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsSkuDetailResponse {

    @ApiModelProperty(value = "sku数据详情")
    private GoodsSkuBaseDetailDTO data;

    @ApiModelProperty(value = "批发商品")
    private List<WholesaleDTO> wholesaleList;

    @ApiModelProperty(value = "分类名称")
    private List<String> categoryName;

    @ApiModelProperty(value = "商品所有sku得规格")
    private List<GoodsSkuSpecDTO> specs;

    @ApiModelProperty(value = "商品参加得营销信息")
    private Map<String,Object> promotionMap;

}
