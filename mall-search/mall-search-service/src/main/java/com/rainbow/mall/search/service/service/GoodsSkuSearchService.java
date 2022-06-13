package com.rainbow.mall.search.service.service;



import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.search.service.pojo.dto.GoodsBaseDTO;
import com.rainbow.mall.search.service.pojo.dto.GoodsSkuSearchDTO;

import java.util.List;

public interface GoodsSkuSearchService {
    /**
     * @Description 商品通用查询
     * @author liuhu
     * @param dto
     * @date 2022/6/12 22:09
     * @return com.rainbow.mall.common.core.dto.base.Page<java.util.List<com.rainbow.mall.search.pojo.dto.GoodsBaseDTO>>
     */
    Page<List<GoodsBaseDTO>> search(GoodsSkuSearchDTO dto);
}