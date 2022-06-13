package com.rainbow.mall.goods.service.service;

import com.rainbow.mall.goods.service.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.CategoryAddDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.CategoryUpdateDTO;

import java.util.List;

public interface CategoryService {
    /**
     * @Description 获取分类树
     * @author liuhu
     * @param parentId
     * @date 2022/6/10 17:58
     * @return java.util.List<com.rainbow.mall.goods.service.pojo.dto.service.BuyerCategoryDTO>
     */
    List<BuyerCategoryDTO> queryAllCategory(String parentId);
    /**
     * @Description 新增分类
     * @author liuhu
     * @param categoryAddDTO
     * @date 2022/6/11 18:37
     * @return void
     */
    void addCategoryList(CategoryAddDTO categoryAddDTO);
    /**
     * @Description 修改分类
     * @author liuhu
     * @param categoryUpdateDTO
     * @date 2022/6/11 18:58
     * @return void
     */
    void updateCategoryList(CategoryUpdateDTO categoryUpdateDTO);
}

