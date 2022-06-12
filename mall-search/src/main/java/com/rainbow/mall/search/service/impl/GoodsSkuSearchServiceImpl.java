package com.rainbow.mall.search.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.core.dto.base.Page;
import com.rainbow.mall.search.convert.GoodsSkuSearchConvert;
import com.rainbow.mall.search.helper.EsHelper;
import com.rainbow.mall.search.pojo.dto.GoodsBaseDTO;
import com.rainbow.mall.search.pojo.dto.GoodsSkuSearchDTO;
import com.rainbow.mall.search.pojo.dto.base.BaseEsQueryParamDTO;
import com.rainbow.mall.search.pojo.po.GoodsEntity;
import com.rainbow.mall.search.service.GoodsSkuSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class GoodsSkuSearchServiceImpl implements GoodsSkuSearchService {

    @Autowired
    private EsHelper esHelper;

    @Autowired
    private GoodsSkuSearchConvert goodsSkuSearchConvert;

    @Override
    public Page<List<GoodsBaseDTO>> search(GoodsSkuSearchDTO dto) {
        log.info("execute search info,req:{}",JSON.toJSONString(dto));
        BoolQueryBuilder queryBuilder = buildGoodsSkuSearchQueryBuilder(dto);
        BaseEsQueryParamDTO baseEsQueryParamDTO = buildBaseEsQueryParamDTO(dto);
        Page<List<GoodsEntity>> originPage = esHelper.queryCommonPage(queryBuilder, baseEsQueryParamDTO, GoodsEntity.class);
        return goodsSkuSearchConvert.convertToGoodsSearchPage(originPage);
    }

    private BaseEsQueryParamDTO buildBaseEsQueryParamDTO(GoodsSkuSearchDTO dto) {
        BaseEsQueryParamDTO queryParamDTO = BaseEsQueryParamDTO.builder().indexName("lili_goods").currentPage(dto.getCurrentPage()).pageSize(dto.getPageSize()).build();
        return queryParamDTO;
    }

    private BoolQueryBuilder buildGoodsSkuSearchQueryBuilder(GoodsSkuSearchDTO dto) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        if(StringUtils.isNotBlank(dto.getSn())){
            queryBuilder.must(QueryBuilders.termQuery(GoodsSkuSearchDTO.Fields.sn,dto.getSn()));
        }
        //未上架的商品不显示
        queryBuilder.must(QueryBuilders.matchQuery("marketEnable", "UPPER"));
        //待审核和审核不通过的商品不显示
        queryBuilder.must(QueryBuilders.matchQuery("authFlag", "PASS"));
        //分类判定
        if (StringUtils.isNotBlank(dto.getCategoryId())) {
            queryBuilder.must(QueryBuilders.wildcardQuery("categoryPath", "*" + dto.getCategoryId() + "*"));
        }
        //店铺分类判定
        if (StringUtils.isNotBlank(dto.getStoreCatId())) {
            queryBuilder.must(QueryBuilders.wildcardQuery("storeCategoryPath", "*" + dto.getStoreCatId() + "*"));
        }
        return queryBuilder;
    }
}
