package com.rainbow.mall.goods.service.controller;


import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.convert.GoodsConvert;
import com.rainbow.mall.goods.service.pojo.dto.service.QueryGoodsSkuListDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.request.QueryGoodsSkuListRequest;
import com.rainbow.mall.goods.service.pojo.response.GoodsRelatedResponse;
import com.rainbow.mall.goods.service.pojo.response.QueryGoodsSkuListResponse;
import com.rainbow.mall.goods.service.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "买家端-商品接口")
@RestController
@RequestMapping("/goods/goods")
public class GoodsBuyerController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsConvert goodsConvert;


    @ApiOperation(value = "获取搜索热词")
    @GetMapping("/hot-words")
    public Result<List<String>> getGoodsHotWords(Integer count) {
        return Result.success(Lists.newArrayList("测试11","测试2222"));
    }


    @GetMapping("es")
    @ApiOperation("通用商品搜索接口")
    @ApiImplicitParam(name = "request",value = "通用商品搜索入参")
    public Result<Page<List<QueryGoodsSkuListResponse>>> querySkuList(QueryGoodsSkuListRequest request){
        QueryGoodsSkuListDTO dto = goodsConvert.convertToQueryGoodsSkuListDTO(request);
        Page<List<QuerySkuListGoodsBaseDTO>> page = goodsService.querySkuList(dto);
        return Result.success(goodsConvert.convertToQueryGoodsSkuListResponse(page));
    }

    @ApiOperation(value = "通过id获取商品信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "goodsId", value = "商品ID", required = true, paramType = "path"),
            @ApiImplicitParam(name = "skuId", value = "skuId", required = true, paramType = "path")
    })
    @GetMapping(value = "/sku/{goodsId}/{skuId}")
    public Result<Map<String, Object>> getSku(@NotNull(message = "商品ID不能为空") @PathVariable("goodsId") String goodsId,
                                                     @NotNull(message = "SKU ID不能为空") @PathVariable("skuId") String skuId) {
            // 读取选中的列表
            Map<String, Object> map = goodsService.getGoodsSkuDetail(goodsId, skuId);
            return Result.success(map);
    }


    @ApiOperation(value = "从ES中获取相关商品品牌名称，分类名称及属性")
//    @GetMapping("/es/related")
    @ApiImplicitParam(name = "request",value = "关联商品入参")
    public Result<GoodsRelatedResponse> getGoodsRelatedByPageFromEs(QueryGoodsSkuListRequest request) {
        String json =
                " {\n" +
                "    \"categories\": [\n" +
                "      {\n" +
                "        \"name\": \"数码办公\",\n" +
                "        \"value\": \"1348576427264204941\",\n" +
                "        \"url\": null,\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"手机通讯\",\n" +
                "        \"value\": \"1348576427264204942\",\n" +
                "        \"url\": null,\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"手机\",\n" +
                "        \"value\": \"1348576427264204943\",\n" +
                "        \"url\": null,\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"摄影摄像\",\n" +
                "        \"value\": \"1348576427264204943\",\n" +
                "        \"url\": null,\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"手机\",\n" +
                "        \"value\": \"1348576427264204944\",\n" +
                "        \"url\": null,\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"对讲机\",\n" +
                "        \"value\": \"1348576427264204946\",\n" +
                "        \"url\": null,\n" +
                "        \"otherOptions\": null\n" +
                "      }\n" +
                "    ],\n" +
                "    \"brands\": [\n" +
                "      {\n" +
                "        \"name\": \"Apple\",\n" +
                "        \"value\": \"1349563815406887117\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406887117.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"马蜂窝\",\n" +
                "        \"value\": \"1349563815406886918\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886918.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"威斯汀\",\n" +
                "        \"value\": \"1349563815406886983\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886983.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"美团111\",\n" +
                "        \"value\": \"1349563815406886916\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886916.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"去哪儿\",\n" +
                "        \"value\": \"1349563815406886917\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/50819dbe9ed645468cbab2a09dc4582f.gif\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"beats\",\n" +
                "        \"value\": \"1349563815406886973\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886973.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"贝亲\",\n" +
                "        \"value\": \"1349563815406886995\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886995.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"ceshi\",\n" +
                "        \"value\": \"1463785610129264642\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/2c5f1e715c624803bfd03065fc2e7278.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"盯盯拍\",\n" +
                "        \"value\": \"1349563815406886925\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886925.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"佳能\",\n" +
                "        \"value\": \"1349563815406886936\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406886936.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"健达\",\n" +
                "        \"value\": \"1349563815406887014\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406887014.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"吉利火星\",\n" +
                "        \"value\": \"1349563815406887026\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/1349563815406887026.png\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Xiaomi\",\n" +
                "        \"value\": \"1478979718795714562\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/3b343c906d9c4872aa811077b5c3ba2c.jpg\",\n" +
                "        \"otherOptions\": null\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"DuangDuang\",\n" +
                "        \"value\": \"1481185934309576705\",\n" +
                "        \"url\": \"https://lilishop-oss.oss-cn-beijing.aliyuncs.com/b10bd36dc4bf4219aeb008138892daa1.gif\",\n" +
                "        \"otherOptions\": null\n" +
                "      }\n" +
                "    ],\n" +
                "    \"paramOptions\": [\n" +
                "      {\n" +
                "        \"key\": \"新旧\",\n" +
                "        \"values\": [\n" +
                "          \"88\",\n" +
                "          \"95\",\n" +
                "          \"99\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"213\",\n" +
                "        \"values\": [\n" +
                "          \"dwa\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"内存\",\n" +
                "        \"values\": [\n" +
                "          \"64G\",\n" +
                "          \"128g\",\n" +
                "          \"512g\",\n" +
                "          \"128G\",\n" +
                "          \"256G\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"外壳\",\n" +
                "        \"values\": [\n" +
                "          \"土豪金\",\n" +
                "          \"玫瑰金\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"容量\",\n" +
                "        \"values\": [\n" +
                "          \"大容量\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"尺寸\",\n" +
                "        \"values\": [\n" +
                "          \"2\"\n" +
                "        ]\n" +
                "      },\n" +
                "      {\n" +
                "        \"key\": \"电池\",\n" +
                "        \"values\": [\n" +
                "          \"锂电池\",\n" +
                "          \"铅电池\"\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "}";
        GoodsRelatedResponse goodsRelatedResponse = JSON.parseObject(json, GoodsRelatedResponse.class);
        return Result.success(goodsRelatedResponse);
    }
}
