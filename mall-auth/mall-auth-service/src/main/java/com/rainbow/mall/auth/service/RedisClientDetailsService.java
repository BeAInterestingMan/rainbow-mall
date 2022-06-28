package com.rainbow.mall.auth.service;

import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.redis.helper.RedisHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
/**
 *  @Description 获取oauth2得客户端授权信息
 *  @author liuhu
 *  @Date 2022/6/28 14:44
 */
@Slf4j
@Service
public class RedisClientDetailsService extends JdbcClientDetailsService {

    private static final String CACHE_CLIENT_KEY = "MALL_CLIENT_DETAILS:";

    @Autowired
    private final RedisHelper redisHelper;

    public RedisClientDetailsService(@Qualifier("dataSource") DataSource dataSource, RedisHelper redisService) {
        super(dataSource);
        this.redisHelper = redisService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws InvalidClientException {
        // 走redis  然后走mysql oauth_client_details
        String value = (String) redisHelper.hGet(CACHE_CLIENT_KEY, clientId);
        if (StringUtils.isNotBlank(value)) {
            return JSON.parseObject(value, BaseClientDetails.class);
        }
        return cacheAndGetClient(clientId);
    }


    public ClientDetails cacheAndGetClient(String clientId) {
        // 从Mysql数据库查询客户端信息
        ClientDetails  clientDetails = super.loadClientByClientId(clientId);
        if (clientDetails != null) {
            BaseClientDetails baseClientDetails = (BaseClientDetails) clientDetails;
            redisHelper.hSet(CACHE_CLIENT_KEY, clientId, JSON.toJSONString(baseClientDetails));
        }
        return clientDetails;
    }

    public static void main(String[] args) {
        // client secret 使用BCryptPasswordEncoder加密
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
    }
}