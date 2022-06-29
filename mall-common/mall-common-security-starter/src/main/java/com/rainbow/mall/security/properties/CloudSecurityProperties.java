package com.rainbow.mall.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = "febs.cloud.security")
public class CloudSecurityProperties {
    /**
     * 配置需要认证的uri，默认为所有/**
     */
    private String authUri = "/**";
    /**
     * 免认证资源路径，支持通配符
     * 多个值时使用逗号分隔
     */
    private String anonUris;
}
