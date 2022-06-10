package com.rainbow.mall.goods.service;


import com.rainbow.mall.goods.pojo.dto.service.BuyerCategoryDTO;

import java.util.List;

public interface CategoryService {
    /**
     * @Description 获取分类树
     * @author liuhu
     * @param parentId
     * @date 2022/6/10 17:58
     * @return java.util.List<com.rainbow.mall.goods.pojo.dto.service.BuyerCategoryDTO>
     */
    List<BuyerCategoryDTO> queryAllCategory(String parentId);
}

