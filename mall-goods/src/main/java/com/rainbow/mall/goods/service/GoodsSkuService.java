package com.rainbow.mall.goods.service;


import com.rainbow.mall.goods.pojo.dto.base.GoodsBaseDTO;

import java.util.List;
import java.util.Map;

public interface GoodsSkuService {


    void createGoodsSku(GoodsBaseDTO goodsBaseDTO, List<Map<String, Object>> skuList);
}

