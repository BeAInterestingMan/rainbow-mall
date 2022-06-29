package com.rainbow.mall.auth.config;

import com.rainbow.mall.auth.properties.MallAuthProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
/**
 *  @Description 资源服务器配置  认证服务器除了认证之外还提供了用户信息服务 所以也是认证服务器
 *  @author liuhu
 *  @Date 2022/6/28 15:07
 */
@Configuration
@EnableResourceServer
public class ResourceServiceConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private MallAuthProperties mallAuthProperties;
    /**
     * @Description 除了白名单得请求  其他所有得请求都需要认证
     * @author liuhu
     * @param http
     * @date 2022/6/28 15:08
     * @return void
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        String[] anonUrls = StringUtils.isBlank(mallAuthProperties.getAnonUrls())?(new String[]{}):mallAuthProperties.getAnonUrls().split(",");
        http.csrf().disable()
                .requestMatchers().antMatchers(mallAuthProperties.getAuthUrl())
                .and().authorizeRequests()
                .antMatchers(anonUrls).permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .httpBasic();

    }
}
