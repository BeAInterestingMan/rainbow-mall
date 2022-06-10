package com.rainbow.mall.cms.pojo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndexPageDataDTO {

    /**"页面类型""INDEX,STORE,SPECIAL"*/
    private String pageType;

    /**"客户端类型"  "PC,H5,WECHAT_MP,APP"*/
    private String pageClientType;

}
