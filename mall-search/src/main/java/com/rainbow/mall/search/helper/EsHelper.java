package com.rainbow.mall.search.helper;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.rainbow.mall.common.core.dto.base.Page;
import com.rainbow.mall.search.pojo.dto.base.BaseEsQueryParamDTO;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *  @Description 封装ES帮助类
 *  @author liuhu
 *  @Date 2022/6/12 22:11
 */
@Component
@Slf4j
public class EsHelper {

    @Autowired
    private RestHighLevelClient client;

    /**
     * @Description 通用分页查询
     * @author liuhu
     * @param queryBuilder
     * @param baseEsQueryDTO
     * @param clazz
     * @date 2022/6/12 22:11
     * @return com.rainbow.mall.common.core.dto.base.Page<java.util.List<T>>
     */
    public <T> Page<List<T>> queryCommonPage(BoolQueryBuilder queryBuilder, BaseEsQueryParamDTO baseEsQueryDTO, Class<T> clazz) {
        Page<List<T>> page = new Page<>();
        page.setCurrentPage(baseEsQueryDTO.getCurrentPage());
        page.setPageSize(baseEsQueryDTO.getPageSize());
        SearchRequest searchRequest = new SearchRequest(baseEsQueryDTO.getIndexName());
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        buildBaseQueryCondition(sourceBuilder,queryBuilder,baseEsQueryDTO);
        log.info("execute queryCommonPage info,query:{}",sourceBuilder.toString());
        searchRequest.source(sourceBuilder);
        try {
            SearchResponse search = client.search(searchRequest, RequestOptions.DEFAULT);
            // 返回总数据条数
            Long total = search.getHits().getTotalHits();
            SearchHit[] searchHits = search.getHits().getHits();
            List<T> data = Arrays.stream(searchHits).map(v -> JSON.parseObject(v.getSourceAsString(), clazz)).collect(Collectors.toList());
            page.setTotal(total);
            page.setData(data);
            return page;
        } catch (Exception e) {
            log.info("execute queryCommonPage error",e);
            return Page.emptyPage(baseEsQueryDTO.getCurrentPage(),baseEsQueryDTO.getPageSize());
        }
    }

    /**
     * @Description 构建分页查询条件
     * @author liuhu
     * @param sourceBuilder
     * @param queryBuilder
     * @param baseEsQueryDTO
     * @date 2022/6/12 21:18
     * @return void
     */
    private void buildBaseQueryCondition(SearchSourceBuilder sourceBuilder,BoolQueryBuilder queryBuilder,BaseEsQueryParamDTO baseEsQueryDTO) {
        // 构建分页参数
        sourceBuilder.from((baseEsQueryDTO.getCurrentPage()-1)*baseEsQueryDTO.getPageSize())
                .size(baseEsQueryDTO.getPageSize()).query(queryBuilder);
        // 构建排序
        if(!CollectionUtils.isEmpty(baseEsQueryDTO.getEsSortParams())){
            baseEsQueryDTO.getEsSortParams().forEach(esSortParamDTO -> sourceBuilder.sort(esSortParamDTO.getName(), Objects.equals(Boolean.FALSE,esSortParamDTO.getDesc())?SortOrder.ASC:SortOrder.DESC));
        }
    }
}
