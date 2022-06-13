package com.rainbow.mall.goods.service.convert;

import com.rainbow.mall.goods.service.entity.Category;
import com.rainbow.mall.goods.service.pojo.dto.base.CategoryBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.CategoryAddDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.CategoryUpdateDTO;
import com.rainbow.mall.goods.service.pojo.request.CategoryAddRequest;
import com.rainbow.mall.goods.service.pojo.request.CategoryUpdateRequest;
import com.rainbow.mall.goods.service.pojo.vo.BuyerCategoryVO;
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
