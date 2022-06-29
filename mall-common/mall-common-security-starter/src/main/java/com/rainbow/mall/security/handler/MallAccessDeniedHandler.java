package com.rainbow.mall.security.handler;


import com.rainbow.mall.security.utils.TokenUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MallAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        TokenUtil.makeJsonResponse(response, HttpServletResponse.SC_FORBIDDEN, "没有权限访问该资源");
    }
}
