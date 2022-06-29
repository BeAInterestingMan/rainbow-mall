package com.rainbow.mall.security.config;

import com.rainbow.mall.security.constants.SecurityConstants;
import com.rainbow.mall.security.handler.MallAccessDeniedHandler;
import com.rainbow.mall.security.handler.MallAuthExceptionEntryPoint;
import com.rainbow.mall.security.utils.TokenUtil;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

@Slf4j
@Configuration
public class CloudResourceSecurityAutoConfig {


    /**
     * @Description 注册用户密码加密bean
     * @author liuhu
     * @date 2022/6/29 16:24
     * @return org.springframework.security.crypto.password.PasswordEncoder
     */
    @Bean
    @ConditionalOnMissingBean(value = PasswordEncoder.class)
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
       return new MallAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint exceptionEntryPoint() {
        return new MallAuthExceptionEntryPoint();
    }
    /**
     * @Description 微服务服务调用中  feign不会自动帮我们转发token 需要前置塞入
     * @author liuhu
     * @date 2022/6/29 16:23
     * @return feign.RequestInterceptor
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return requestTemplate -> {
            String tokenValue = TokenUtil.getCurrentTokenValue();
            if (StringUtils.isNotBlank(tokenValue)) {
                requestTemplate.header(HttpHeaders.AUTHORIZATION, SecurityConstants.OAUTH2_TOKEN_TYPE + tokenValue);
            }
        };
    }
}
