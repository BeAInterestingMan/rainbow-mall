package com.rainbow.mall.cms.service.impl;


import com.rainbow.mall.cms.convert.PageDataConvert;
import com.rainbow.mall.cms.pojo.dto.base.PageDataBaseDTO;
import com.rainbow.mall.cms.pojo.dto.request.IndexPageDataDTO;
import com.rainbow.mall.cms.pojo.dto.service.PageDataDTO;
import com.rainbow.mall.cms.repository.PageDataRepository;
import com.rainbow.mall.cms.service.PageDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageDataServiceImpl implements PageDataService {

    @Autowired
    private PageDataRepository pageDataRepository;

    @Autowired
    private PageDataConvert pageDataConvert;

    @Override
    public PageDataDTO getIndexPageData(IndexPageDataDTO dataDTO) {
        PageDataBaseDTO pageDataBaseDTO = pageDataRepository.getByClientTypeAndPageType(dataDTO);
        return pageDataConvert.convertToPageDataDTO(pageDataBaseDTO);
    }
}