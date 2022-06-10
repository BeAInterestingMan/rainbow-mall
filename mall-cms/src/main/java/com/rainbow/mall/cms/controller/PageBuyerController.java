package com.rainbow.mall.cms.controller;


import com.rainbow.mall.cms.convert.PageDataConvert;
import com.rainbow.mall.cms.enums.PageEnum;
import com.rainbow.mall.cms.pojo.dto.request.IndexPageDataDTO;
import com.rainbow.mall.cms.pojo.dto.service.PageDataDTO;
import com.rainbow.mall.cms.pojo.vo.PageDataVO;
import com.rainbow.mall.cms.service.PageDataService;
import com.rainbow.mall.common.core.dto.base.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "买家端-页面接口")
@RequestMapping("/other/pageData")
public class PageBuyerController {

    @Autowired
    private PageDataService pageDataService;

    @Autowired
    private PageDataConvert pageDataConvert;

    @ApiOperation(value = "获取首页数据")
    @ApiImplicitParam(name = "clientType",value = "客户端类型")
    @GetMapping("/getIndex")
    public Result<PageDataVO> getIndexPageData(@RequestParam String clientType) {
        IndexPageDataDTO dataDTO = IndexPageDataDTO.builder().pageClientType(clientType).pageType(PageEnum.INDEX.value()).build();
        PageDataDTO pageDataDTO = pageDataService.getIndexPageData(dataDTO);
        return Result.success(pageDataConvert.convertToPageDataVO(pageDataDTO));
    }
}
