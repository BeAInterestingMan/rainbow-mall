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
    /**
     * @Description 清空购物车
     * @author liuhu
     * @param
     * @date 2022/6/28 9:42
     * @return void
     */
    void clean();
    /**
     * @Description 批量删除购物车sku
     * @author liuhu
     * @param skuIds
     * @date 2022/6/28 10:00
     * @return void
     */
    void delete(String[] skuIds);
    /**
     * @Description 获取购物车数量
     * @author liuhu
     * @date 2022/6/28 10:39
     * @return java.lang.Long
     */
    Integer getCartNum();
}
