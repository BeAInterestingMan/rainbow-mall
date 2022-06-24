package com.rainbow.mall.common.datasource.config;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.rainbow.mall.common.datasource.helper.MybatisBatchHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 *  @Description mybatis 配置
 *  @author liuhu
 *  @Date 2022/5/14 17:13
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * @Description 注册分页插件
     * @author liuhu
     * @date 2022/5/14 17:12
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        List<ISqlParser> sqlParserList = new ArrayList<>();
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    @Bean
    public MybatisBatchHelper registerMybatisBatchHelper(){
        return new MybatisBatchHelper();
    }
}