package com.rainbow.mall.goods.service.service;

import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.goods.service.pojo.dto.service.GoodsCreateDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QueryGoodsSkuListDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO;

import java.util.List;
import java.util.Map;

public interface GoodsService {

    /**
     * @Description 新增商品
     * @author liuhu
     * @param goodsCreateDTO
     * @date 2022/6/12 19:42
     * @return void
     */
    void createGoods(GoodsCreateDTO goodsCreateDTO);
    /**
     * @Description 通用商品搜索
     * @author liuhu
     * @param dto
     * @date 2022/6/13 15:22
     * @return com.rainbow.mall.common.entity.entity.base.Page<java.util.List<com.rainbow.mall.goods.service.pojo.dto.service.QuerySkuListGoodsBaseDTO>>
     */
    Page<List<QuerySkuListGoodsBaseDTO>> querySkuList(QueryGoodsSkuListDTO dto);

    Map<String, Object> getGoodsSkuDetail(String goodsId, String skuId);
}

