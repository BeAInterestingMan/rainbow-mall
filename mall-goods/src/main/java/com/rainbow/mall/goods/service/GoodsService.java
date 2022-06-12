package com.rainbow.mall.goods.service;

import com.rainbow.mall.goods.pojo.dto.service.GoodsCreateDTO;

public interface GoodsService {

    /**
     * @Description 新增商品
     * @author liuhu
     * @param goodsCreateDTO
     * @date 2022/6/12 19:42
     * @return void
     */
    void createGoods(GoodsCreateDTO goodsCreateDTO);
}

