package com.rainbow.mall.auth.service;

import com.rainbow.mall.auth.pojo.base.AdminUserBaseDTO;
import com.rainbow.mall.auth.pojo.entity.AdminUser;

public interface AdminUserService {
    AdminUserBaseDTO getCurrentUser(String username);
}
