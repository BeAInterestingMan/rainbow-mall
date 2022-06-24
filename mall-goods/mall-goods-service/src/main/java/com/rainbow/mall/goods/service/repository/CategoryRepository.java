package com.rainbow.mall.goods.service.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.collect.Lists;
import com.rainbow.mall.goods.service.convert.CategoryConvert;
import com.rainbow.mall.goods.service.pojo.entity.Category;
import com.rainbow.mall.goods.service.mapper.CategoryMapper;
import com.rainbow.mall.goods.service.pojo.dto.base.CategoryBaseDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 19:19:50
 */
@Repository
public class  CategoryRepository {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryConvert categoryConvert;

    public List<CategoryBaseDTO> queryAll() {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getDeleteFlag, false);
        List<Category> categories = categoryMapper.selectList(queryWrapper);
        return categoryConvert.convertCategoryBaseDTOList(categories);
    }

    public CategoryBaseDTO getById(String categoryId) {
        if(StringUtils.isBlank(categoryId)){
            return null;
        }
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getId,categoryId)
                    .eq(Category::getDeleteFlag, false);
        Category category = categoryMapper.selectOne(queryWrapper);
        return categoryConvert.convertCategoryBaseDTO(category);
    }

    public void insert(CategoryBaseDTO categoryBaseDTO) {
        Category category = categoryConvert.convertTOCategory(categoryBaseDTO);
        if(Objects.isNull(category)){
            return;
        }
        categoryMapper.insert(category);
    }

    public void update(CategoryBaseDTO updateCategoryBaseDTO) {
        Category category = categoryConvert.convertTOCategory(updateCategoryBaseDTO);
        if(Objects.isNull(category)){
            return;
        }
        categoryMapper.updateById(category);
    }

    public List<CategoryBaseDTO> queryByIdList(List<String> categoryIdList) {
        if(CollectionUtils.isEmpty(categoryIdList)){
            return Lists.newArrayList();
        }
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Category::getId,categoryIdList)
                .eq(Category::getDeleteFlag, false);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
        return categoryConvert.convertCategoryBaseDTOList(categoryList);
    }
}
