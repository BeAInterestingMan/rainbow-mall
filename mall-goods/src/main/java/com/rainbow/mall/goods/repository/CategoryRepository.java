package com.rainbow.mall.goods.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbow.mall.goods.convert.CategoryConvert;
import com.rainbow.mall.goods.entity.Category;
import com.rainbow.mall.goods.mapper.CategoryMapper;
import com.rainbow.mall.goods.pojo.dto.base.CategoryBaseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
