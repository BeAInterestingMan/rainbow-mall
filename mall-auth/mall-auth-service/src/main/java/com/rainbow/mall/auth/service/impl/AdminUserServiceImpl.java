package com.rainbow.mall.auth.service.impl;

import com.rainbow.mall.auth.pojo.base.AdminUserBaseDTO;
import com.rainbow.mall.auth.repository.AdminUserRepository;
import com.rainbow.mall.auth.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Override
    public AdminUserBaseDTO getCurrentUser(String username) {
        return adminUserRepository.getCurrentUser(username);
    }
}
