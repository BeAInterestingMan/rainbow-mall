package com.rainbow.mall.goods.service.impl;

import com.google.common.collect.Lists;
import com.rainbow.mall.goods.convert.CategoryConvert;
import com.rainbow.mall.goods.enums.ResultCode;
import com.rainbow.mall.goods.exception.GoodsServiceException;
import com.rainbow.mall.goods.pojo.dto.base.CategoryBaseDTO;
import com.rainbow.mall.goods.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.pojo.dto.service.CategoryAddDTO;
import com.rainbow.mall.goods.pojo.dto.service.CategoryUpdateDTO;
import com.rainbow.mall.goods.repository.CategoryRepository;
import com.rainbow.mall.goods.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryConvert categoryConvert;

    @Override
    public List<BuyerCategoryDTO> queryAllCategory(String parentId) {
        if(StringUtils.isBlank(parentId)){
            return Lists.newArrayList();
        }
        List<CategoryBaseDTO> originCategoryBaseDTOS = categoryRepository.queryAll();
        List<BuyerCategoryDTO> baseDTOS = originCategoryBaseDTOS.stream().filter(categoryBaseDTO -> Objects.equals(String.valueOf(categoryBaseDTO.getParentId()), parentId))
                .map(categoryBaseDTO -> {
                    BuyerCategoryDTO buyerCategoryDTO = categoryConvert.convertToBuyerCategoryDTO(categoryBaseDTO);
                    List<BuyerCategoryDTO> childrenCategoryBaseDTOS = getChildren(categoryBaseDTO, originCategoryBaseDTOS);
                    buyerCategoryDTO.setChildren(childrenCategoryBaseDTOS);
                    return buyerCategoryDTO;
                }).collect(Collectors.toList());
        return categoryConvert.convertBuyerCategoryDTOList(baseDTOS);
    }

    @Override
    public void addCategoryList(CategoryAddDTO categoryAddDTO) {
        if (!"0".equals(categoryAddDTO.getParentId())) {
            CategoryBaseDTO  categoryBaseDTO =  categoryRepository.getById(categoryAddDTO.getParentId());
            if(Objects.isNull(categoryBaseDTO)){
                throw new GoodsServiceException(ResultCode.CATEGORY_PARENT_NOT_EXIST);
            }
        }
        CategoryBaseDTO categoryBaseDTO = categoryConvert.convertCategoryBaseDTO(categoryAddDTO);
        categoryRepository.insert(categoryBaseDTO);
    }

    @Override
    public void updateCategoryList(CategoryUpdateDTO categoryUpdateDTO) {
        CategoryBaseDTO  categoryBaseDTO =  categoryRepository.getById(categoryUpdateDTO.getId());
        if(Objects.isNull(categoryBaseDTO)){
            throw new GoodsServiceException(ResultCode.CATEGORY_NOT_EXIST);
        }
        CategoryBaseDTO updateCategoryBaseDTO = categoryConvert.convertCategoryBaseDTO(categoryUpdateDTO);
        categoryRepository.update(updateCategoryBaseDTO);
    }

    /**
     * @Description 递归获取子菜单
     * @author liuhu
     * @param currentCategory
     * @param originCategoryBaseDTOS
     * @date 2022/6/10 17:57
     * @return java.util.List<com.rainbow.mall.goods.pojo.dto.base.BuyerCategoryBaseDTO>
     */
    private List<BuyerCategoryDTO> getChildren(CategoryBaseDTO currentCategory, List<CategoryBaseDTO> originCategoryBaseDTOS) {
        return  originCategoryBaseDTOS.stream().filter(categoryBaseDTO -> Objects.equals(String.valueOf(currentCategory.getId()), categoryBaseDTO.getParentId()))
                .map(categoryBaseDTO -> {
                    BuyerCategoryDTO buyerCategoryDTO = categoryConvert.convertToBuyerCategoryDTO(categoryBaseDTO);
                    List<BuyerCategoryDTO> children = getChildren(categoryBaseDTO, originCategoryBaseDTOS);
                    buyerCategoryDTO.setChildren(children);
                    return buyerCategoryDTO;
                }).collect(Collectors.toList());
    }
}