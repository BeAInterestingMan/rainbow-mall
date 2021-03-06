package com.rainbow.mall.auth.config;

import com.rainbow.mall.auth.service.impl.RedisClientDetailsService;
import com.rainbow.mall.auth.service.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.util.UUID;

/**
 *  @Description 认证服务器 所有需要用户权限得接口统一走认证
 *  @author liuhu
 *  @Date 2022/6/28 13:31
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private RedisClientDetailsService redisClientDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private UserDetailService userDetailService;

    /**
     * @Description 配置获取认证客户端得信息
     * @author liuhu
     * @param clients
     * @date 2022/6/28 13:30
     * @return void
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(redisClientDetailsService);
    }

    /**
     * @Description 配置访问端点
     * @author liuhu
     * @param endpoints
     * @date 2022/6/28 13:30
     * @return void
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                // 配置用户密码信息认证
                .userDetailsService(userDetailService)
                // 配置Token存储
                .tokenStore(tokenStore())
                //refresh_token是否重复使用
                .reuseRefreshTokens(false)
                // 配置token策略
                .tokenServices(defaultTokenServices())
                // oath2密码模式必须配置
                .authenticationManager(authenticationManager);
    }

    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(redisClientDetailsService);
        return tokenServices;
    }


    /**
     * @Description access_token信息存储方式
     * @author liuhu
     * @date 2022/6/28 14:50
     * @return org.springframework.security.oauth2.provider.token.TokenStore
     */
    @Bean
    @Primary
    public TokenStore tokenStore() {
        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
        // 解决每次生成的 token都一样的问题 TODO
        redisTokenStore.setAuthenticationKeyGenerator(oAuth2Authentication -> UUID.randomUUID().toString().replace("-",""));
        return redisTokenStore;
    }
}
