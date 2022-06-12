package com.rainbow.mall.goods.convert;

import com.rainbow.mall.goods.entity.Category;
import com.rainbow.mall.goods.pojo.dto.base.CategoryBaseDTO;
import com.rainbow.mall.goods.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.pojo.dto.service.CategoryAddDTO;
import com.rainbow.mall.goods.pojo.dto.service.CategoryUpdateDTO;
import com.rainbow.mall.goods.pojo.request.CategoryAddRequest;
import com.rainbow.mall.goods.pojo.request.CategoryUpdateRequest;
import com.rainbow.mall.goods.pojo.vo.BuyerCategoryVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryConvert {
    
    List<BuyerCategoryVO> convertBuyerCategoryVOList(List<BuyerCategoryDTO> buyerCategoryDTOS);

    List<CategoryBaseDTO> convertCategoryBaseDTOList(List<Category> categories);

    BuyerCategoryDTO convertToBuyerCategoryDTO(CategoryBaseDTO categoryBaseDTO);

    List<BuyerCategoryDTO> convertBuyerCategoryDTOList(List<BuyerCategoryDTO> baseDTOS);

    CategoryAddDTO convertCategoryAddDTO(CategoryAddRequest request);

    CategoryBaseDTO convertCategoryBaseDTO(Category category);

    CategoryBaseDTO convertCategoryBaseDTO(CategoryAddDTO category);

    CategoryBaseDTO convertCategoryBaseDTO(CategoryUpdateDTO category);

    Category convertTOCategory(CategoryBaseDTO categoryBaseDTO);

    CategoryUpdateDTO convertCategoryUpdateDTO(CategoryUpdateRequest request);
}
