package com.rainbow.mall.cms.convert;

import com.rainbow.mall.cms.pojo.entity.PageData;
import com.rainbow.mall.cms.pojo.dto.base.PageDataBaseDTO;
import com.rainbow.mall.cms.pojo.dto.service.PageDataDTO;
import com.rainbow.mall.cms.pojo.vo.PageDataVO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PageDataConvert {

    PageDataBaseDTO convertToPageDataBaseDTO(PageData pageData);

    PageDataDTO convertToPageDataDTO(PageDataBaseDTO pageDataBaseDTO);

    PageDataVO convertToPageDataVO(PageDataDTO pageDataDTO);
}
