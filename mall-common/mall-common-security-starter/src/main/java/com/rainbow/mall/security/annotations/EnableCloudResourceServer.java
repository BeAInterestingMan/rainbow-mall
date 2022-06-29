package com.rainbow.mall.security.annotations;

import com.rainbow.mall.security.config.CloudResourceServerConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 *  @Description 自定义注解 加上该注解开启资源服务器配置
 *  @author liuhu
 *  @Date 2022/6/13 11:22
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(CloudResourceServerConfigure.class)
public @interface EnableCloudResourceServer {
}