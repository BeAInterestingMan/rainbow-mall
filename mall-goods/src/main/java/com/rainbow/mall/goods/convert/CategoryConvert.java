package com.rainbow.mall.goods.convert;

import com.rainbow.mall.goods.entity.Category;
import com.rainbow.mall.goods.pojo.dto.base.CategoryBaseDTO;
import com.rainbow.mall.goods.pojo.dto.service.BuyerCategoryDTO;
import com.rainbow.mall.goods.pojo.vo.BuyerCategoryVO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryConvert {
    
    List<BuyerCategoryVO> convertBuyerCategoryVOList(List<BuyerCategoryDTO> buyerCategoryDTOS);

    List<CategoryBaseDTO> convertCategoryBaseDTOList(List<Category> categories);

    BuyerCategoryDTO convertToBuyerCategoryDTO(CategoryBaseDTO categoryBaseDTO);

    List<BuyerCategoryDTO> convertBuyerCategoryDTOList(List<BuyerCategoryDTO> baseDTOS);
}
