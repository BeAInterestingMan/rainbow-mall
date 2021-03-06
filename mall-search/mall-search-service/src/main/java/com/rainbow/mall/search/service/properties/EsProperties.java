package com.rainbow.mall.search.service.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *  @Description es配置
 *  @author liuhu
 *  @Date 2022/6/12 20:02
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "elasticsearch.config")
public class EsProperties {

    private String host;

    private Integer port;
    /**
     * 使用的协议
     */
    private String schema = "http";
    /**
     * 连接超时时间
     */
    private int connectTimeOut = 1000;
    /**
     * 连接超时时间
     */
    private int socketTimeOut = 30000;
    /**
     * 获取连接的超时时间
     */
    private int connectionRequestTimeOut = 500;
    /**
     * 最大连接数
     */
    private int maxConnectTotal = 100;
    /**
     * 最大路由连接数
     */
    private int maxConnectPerRoute = 100;

}