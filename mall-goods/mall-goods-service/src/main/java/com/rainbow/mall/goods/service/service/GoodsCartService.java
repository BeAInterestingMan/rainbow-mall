package com.rainbow.mall.goods.service.service;

import com.rainbow.mall.goods.service.pojo.dto.service.cart.GoodsCartSaveDTO;

public interface GoodsCartService {
    /**
     * @Description 购物车新增
     * @author liuhu
     * @param goodsCartAddDTO
     * @date 2022/6/27 13:10
     * @return void
     */
    void add(GoodsCartSaveDTO goodsCartAddDTO);
}
