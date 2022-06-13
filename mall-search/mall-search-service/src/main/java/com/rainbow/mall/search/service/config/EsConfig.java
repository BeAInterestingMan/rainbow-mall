package com.rainbow.mall.search.service.config;

import com.rainbow.mall.search.service.properties.EsProperties;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  @Description RestHighLevelClient 配置类
 *  @author liuhu
 *  @Date 2022/6/12 20:03
 */
@Configuration
public class EsConfig {

    @Autowired
    private EsProperties esProperties;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestClientBuilder builder = RestClient.builder(new HttpHost("localhost",9200,esProperties.getSchema()));
        // 异步httpclient连接延时配置
        builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
            @Override
            public Builder customizeRequestConfig(Builder requestConfigBuilder) {
                requestConfigBuilder.setConnectTimeout(esProperties.getConnectTimeOut());
                requestConfigBuilder.setSocketTimeout(esProperties.getSocketTimeOut());
                requestConfigBuilder.setConnectionRequestTimeout(esProperties.getConnectionRequestTimeOut());
                return requestConfigBuilder;
            }
        });
        // 异步httpclient连接数配置
        builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
            @Override
            public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
                httpClientBuilder.setMaxConnTotal(esProperties.getMaxConnectTotal());
                httpClientBuilder.setMaxConnPerRoute(esProperties.getMaxConnectPerRoute());
                return httpClientBuilder;
            }
        });
        return new RestHighLevelClient(builder);
    }
}
