package com.rainbow.mall.base.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
/**
 *  @Description minio参数
 *  @author liuhu
 *  @Date 2022/6/14 15:00
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mall.minio")
public class MinioProperties {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
