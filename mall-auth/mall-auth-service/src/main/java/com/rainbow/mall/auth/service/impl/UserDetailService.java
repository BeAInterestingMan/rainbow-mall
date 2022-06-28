package com.rainbow.mall.auth.service.impl;

import com.rainbow.mall.auth.enums.LoginTypeEnum;
import com.rainbow.mall.auth.pojo.base.AdminUserBaseDTO;
import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;
import com.rainbow.mall.auth.service.AdminUserService;
import com.rainbow.mall.auth.service.MemberService;
import com.rainbow.mall.auth.util.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
/**
 *  @Description 用户认证服务  这里把前台和后台放在一起校验了  建议拆分
 *  @author liuhu
 *  @Date 2022/6/28 19:55
 */
@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Autowired
    private MemberService memberService;

    @Autowired
    private AdminUserService adminUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        HttpServletRequest httpServletRequest = RequestUtil.getHttpServletRequest();
        String loginType = httpServletRequest.getParameter("login_type");
        if(StringUtils.isBlank(loginType)){
            throw new UsernameNotFoundException("参数错误");
        }
        return handlerAuth(loginType,username);
    }


    public User handlerAuth(String loginType,String username){
        LoginTypeEnum loginTypeEnum = LoginTypeEnum.getByName(loginType);
        User user = null;
        switch (loginTypeEnum){

            case ADMIN:
                // 查询后台用户信息
                AdminUserBaseDTO currentUser = adminUserService.getCurrentUser(username);
                if(Objects.isNull(currentUser)){
                    throw new UsernameNotFoundException("");
                }
                user = new User(currentUser.getUsername(),currentUser.getPassword(),AuthorityUtils.NO_AUTHORITIES);
                break;

            case APP:
                // 查询会员信息
                MemberBaseDTO baseDTO = memberService.getByPhone(username);
                if(Objects.isNull(baseDTO)){
                    throw new UsernameNotFoundException("");
                }
                user = new User(baseDTO.getUsername(),baseDTO.getPassword(),AuthorityUtils.NO_AUTHORITIES);
                break;

            default:

                break;
        }
        return user;
    }
}
