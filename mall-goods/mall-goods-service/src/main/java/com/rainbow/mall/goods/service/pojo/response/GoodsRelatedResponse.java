package com.rainbow.mall.goods.service.pojo.response;

import com.rainbow.mall.goods.service.pojo.dto.service.ParamOptionsDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.SelectorOptionsDTO;
import lombok.Data;

import java.util.List;


@Data
public class GoodsRelatedResponse {

    /**
     * 分类集合
     */
    private List<SelectorOptionsDTO> categories;

    /**
     * 品牌集合
     */
    private List<SelectorOptionsDTO> brands;

    /**
     * 参数集合
     */
    private List<ParamOptionsDTO> paramOptions;
}
