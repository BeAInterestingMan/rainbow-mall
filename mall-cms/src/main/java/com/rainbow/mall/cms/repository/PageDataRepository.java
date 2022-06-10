package com.rainbow.mall.cms.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbow.mall.cms.convert.PageDataConvert;
import com.rainbow.mall.cms.pojo.entity.PageData;
import com.rainbow.mall.cms.enums.SwitchEnum;
import com.rainbow.mall.cms.mapper.PageDataMapper;
import com.rainbow.mall.cms.pojo.dto.base.PageDataBaseDTO;
import com.rainbow.mall.cms.pojo.dto.request.IndexPageDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
public class  PageDataRepository {

    @Autowired
    private PageDataMapper pageDataMapper;

    @Autowired
    private PageDataConvert pageDataConvert;

    public PageDataBaseDTO getByClientTypeAndPageType(IndexPageDataDTO dataDTO) {
        LambdaQueryWrapper<PageData> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(PageData::getPageType, dataDTO.getPageType());
        queryWrapper.eq(PageData::getPageShow, SwitchEnum.OPEN.name());
        queryWrapper.eq(PageData::getPageClientType, dataDTO.getPageClientType());
        PageData pageData = pageDataMapper.selectOne(queryWrapper);
        return pageDataConvert.convertToPageDataBaseDTO(pageData);
    }
}
