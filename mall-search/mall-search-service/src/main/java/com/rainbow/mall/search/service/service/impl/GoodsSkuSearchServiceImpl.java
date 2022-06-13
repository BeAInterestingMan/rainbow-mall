package com.rainbow.mall.search.service.service.impl;

import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.entity.entity.base.Page;
import com.rainbow.mall.search.service.convert.GoodsSkuSearchConvert;
import com.rainbow.mall.search.service.helper.EsHelper;
import com.rainbow.mall.search.service.pojo.dto.GoodsBaseDTO;
import com.rainbow.mall.search.service.pojo.dto.GoodsSkuSearchDTO;
import com.rainbow.mall.search.service.pojo.dto.base.BaseEsQueryParamDTO;
import com.rainbow.mall.search.service.pojo.po.GoodsEntity;
import com.rainbow.mall.search.service.service.GoodsSkuSearchService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

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
        Page<List<GoodsEntity>> listPage = queryEsGoodsPage(dto);
        return goodsSkuSearchConvert.convertToGoodsSearchPage(listPage);
    }

    private  Page<List<GoodsEntity>> queryEsGoodsPage(GoodsSkuSearchDTO dto) {
        BoolQueryBuilder queryBuilder = buildGoodsSkuSearchQueryBuilder(dto);
        BaseEsQueryParamDTO baseEsQueryParamDTO = buildBaseEsQueryParamDTO(dto);
        return esHelper.queryCommonPage(queryBuilder, baseEsQueryParamDTO, GoodsEntity.class);
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
        if(StringUtils.isNotBlank(dto.getBrandId())){
            queryBuilder.must(QueryBuilders.termQuery(GoodsSkuSearchDTO.Fields.brandId,dto.getBrandId()));
        }
        //规格项判定 nestedQuery子查询
        if (!CollectionUtils.isEmpty(dto.getNameIds())) {
            queryBuilder.must(QueryBuilders.nestedQuery("attrList", QueryBuilders.termQuery("attrList.nameId", dto.getNameIds()),ScoreMode.None));
        }
        if (Objects.nonNull(dto.getRecommend())) {
            queryBuilder.filter(QueryBuilders.termQuery(GoodsSkuSearchDTO.Fields.recommend, dto.getRecommend()));
        }
        if (StringUtils.isNotBlank(dto.getKeyword())) {
            queryBuilder.must(QueryBuilders.matchQuery(GoodsSkuSearchDTO.Fields.keyword,dto.getKeyword()));
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
        if (StringUtils.isNotBlank(dto.getStoreId())) {
            queryBuilder.filter(QueryBuilders.termQuery(GoodsSkuSearchDTO.Fields.storeId, dto.getStoreId()));
        }
        return queryBuilder;
    }
}