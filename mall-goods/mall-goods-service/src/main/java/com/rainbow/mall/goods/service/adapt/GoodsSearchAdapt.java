package com.rainbow.mall.goods.service.adapt;

import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.goods.service.adapt.dto.GoodsSkuSearchAdaptDTO;
import com.rainbow.mall.goods.service.adapt.dto.GoodsSkuSearchAdaptParamDTO;
import com.rainbow.mall.goods.service.convert.GoodsConvert;
import com.rainbow.mall.search.api.feign.GoodsSearchFeign;
import com.rainbow.mall.search.api.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.api.pojo.response.GoodsSkuSearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class GoodsSearchAdapt {

    @Autowired
    private GoodsSearchFeign goodsSearchFeign;

    @Autowired
    private GoodsConvert goodsConvert;

    public Page<List<GoodsSkuSearchAdaptDTO>> goodsSearch(@RequestParam("request") GoodsSkuSearchAdaptParamDTO request){
        log.info("execute goodsSearch info req:{}", JSON.toJSONString(request));
        GoodsSkuSearchRequest skuSearchRequest = goodsConvert.convertToGoodsSkuSearchRequest(request);
        Result<Page<List<GoodsSkuSearchResponse>>> result = goodsSearchFeign.search(skuSearchRequest);
        if(Objects.isNull(result) || !result.isSuccess()){
            log.error("execute goodsSearch error req:{},resp:{}", JSON.toJSONString(request),JSON.toJSONString(result));
            return  Page.emptyPage(request.getCurrentPage(),request.getPageSize());
        }
        if(Objects.nonNull(result.getResult()) && CollectionUtils.isEmpty(result.getResult().getData())){
            log.warn("execute goodsSearch has empty data req:{}", JSON.toJSONString(request));
            return  Page.emptyPage(request.getCurrentPage(),request.getPageSize());
        }
        return goodsConvert.convertToGoodsSkuSearchAdaptDTOList(result.getResult());
    }
}
