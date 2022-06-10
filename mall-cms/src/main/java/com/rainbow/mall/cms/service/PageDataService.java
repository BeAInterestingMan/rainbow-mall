package com.rainbow.mall.cms.service;

import com.rainbow.mall.cms.pojo.dto.request.IndexPageDataDTO;
import com.rainbow.mall.cms.pojo.dto.service.PageDataDTO;

public interface PageDataService {
    PageDataDTO getIndexPageData(IndexPageDataDTO dataDTO);
}

