package com.rainbow.mall.security.handler;


import com.rainbow.mall.security.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class MallAuthExceptionEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        String message = "请求："+request.getRequestURI()+"，访问令牌不合法";
        log.error("客户端访问{}请求失败: {}", request.getRequestURI(), message, authException);
        TokenUtil.makeJsonResponse(response, HttpServletResponse.SC_UNAUTHORIZED, message);
    }
}
