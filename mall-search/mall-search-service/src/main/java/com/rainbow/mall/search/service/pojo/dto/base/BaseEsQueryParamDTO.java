package com.rainbow.mall.search.service.pojo.dto.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 *  @Description es查询通用字段
 *  @author liuhu
 *  @Date 2022/6/12 21:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseEsQueryParamDTO {

    /**索引名称*/
    private String indexName;

    /**当前页*/
    private Integer currentPage =1;

    /**数量*/
    private Integer pageSize =20;

    /**排序字段*/
    private List<EsSortParamDTO> esSortParams;
}
