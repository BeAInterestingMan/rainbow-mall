package com.rainbow.mall.search.api.feign;


import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.search.api.fallback.GoodsSearchFeignFallback;
import com.rainbow.mall.search.api.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.api.pojo.response.GoodsSkuSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(value = "mall-goods-search",fallbackFactory = GoodsSearchFeignFallback.class)
public interface GoodsSearchFeign {

     @GetMapping("/goods/goods/es")
     Result<Page<List<GoodsSkuSearchResponse>>> search(GoodsSkuSearchRequest request);
}