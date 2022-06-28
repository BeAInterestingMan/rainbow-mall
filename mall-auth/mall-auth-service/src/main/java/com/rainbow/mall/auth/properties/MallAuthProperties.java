package com.rainbow.mall.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Data
@ConfigurationProperties(prefix = "mall.auth")
@Configuration
public class MallAuthProperties {

    /**需要认证url*/
    private String authUrl="/**";

    /**无需认证url*/
    private String anonUrls="/oauth";
}
