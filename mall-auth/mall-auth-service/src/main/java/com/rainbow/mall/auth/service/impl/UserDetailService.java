package com.rainbow.mall.auth.service.impl;

import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;
import com.rainbow.mall.auth.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String password = passwordEncoder.encode("123456");
        //账号fox，密码123456
        return handlerAuth("app",username);
    }


    public User handlerAuth(String loginType,String username){
        User user = null;
        switch (loginType){

            case "admin":
                // 查询后台用户信息
                break;

            case "app":
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
