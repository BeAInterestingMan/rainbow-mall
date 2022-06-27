package com.rainbow.mall.goods.service.service;


import com.rainbow.mall.goods.service.pojo.dto.base.GoodsBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO;

import java.util.List;
import java.util.Map;

public interface GoodsSkuService {

    /**
     * @Description 创建商品
     * @author liuhu
     * @param goodsBaseDTO
     * @param skuList
     * @date 2022/6/14 10:41
     * @return void
     */
    void createGoodsSku(GoodsBaseDTO goodsBaseDTO, List<Map<String, Object>> skuList);

    /**
     * @Description 根据skuId查询
     * @author liuhu
     * @param skuIdList
     * @date 2022/6/14 10:41
     * @return java.util.List<com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO>
     */
    List<GoodsSkuBaseDTO> queryBySkuIdList(List<String> skuIdList);

    /**
     * @Description 获取sku详情
     * @author liuhu
     * @param skuId
     * @date 2022/6/27 16:00
     * @return com.rainbow.mall.goods.service.pojo.dto.service.sku.GoodsSkuBaseDetailDTO
     */
    GoodsSkuBaseDetailDTO getSkuDetailInfo(String skuId);

    /**
     * @Description 通过ID查询
     * @author liuhu
     * @param goodsId
     * @date 2022/6/27 15:59
     * @return java.util.List<com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO>
     */
    List<GoodsSkuBaseDTO> getByGoodsId(String goodsId);
    /**
     * @Description skuId查询
     * @author liuhu
     * @param skuId
     * @date 2022/6/27 13:24
     * @return com.rainbow.mall.goods.service.pojo.dto.base.GoodsSkuBaseDTO
     */
    GoodsSkuBaseDTO getBySkuId(String skuId);
}

