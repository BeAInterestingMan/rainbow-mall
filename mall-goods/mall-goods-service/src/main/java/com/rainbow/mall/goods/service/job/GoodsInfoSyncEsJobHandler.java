package com.rainbow.mall.goods.service.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GoodsInfoSyncEsJobHandler {

    @XxlJob("goodsInfoSyncEsJobHandler")
    public void goodsInfoSyncEsJobHandler(){
        log.info("xxxxxxxxxxxxxxxxxxxx");
        XxlJobHelper.log("xxl");
    }
}
