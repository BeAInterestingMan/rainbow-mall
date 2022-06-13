package com.rainbow.mall.search.api.fallback;

import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.common.entity.entity.base.Result;
import com.rainbow.mall.search.api.feign.GoodsSearchFeign;
import com.rainbow.mall.search.api.pojo.request.GoodsSkuSearchRequest;
import com.rainbow.mall.search.api.pojo.response.GoodsSkuSearchResponse;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class GoodsSearchFeignFallback implements FallbackFactory<GoodsSearchFeign> {

    @Override
    public GoodsSearchFeign create(Throwable throwable) {
        return new GoodsSearchFeign() {
            @Override
            public Result<Page<List<GoodsSkuSearchResponse>>> search(GoodsSkuSearchRequest request) {
                log.error("execute search GoodsSearchFeignFallback info",throwable);
                return Result.error("500","feign调用异常");
            }
        };
    }
}
