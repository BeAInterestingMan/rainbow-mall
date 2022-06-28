package com.rainbow.mall.auth.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbow.mall.auth.convert.AdminUserConvert;
import com.rainbow.mall.auth.mapper.AdminUserMapper;
import com.rainbow.mall.auth.pojo.base.AdminUserBaseDTO;
import com.rainbow.mall.auth.pojo.entity.AdminUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AdminUserRepository {

    @Autowired
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserConvert adminUserConvert;

    public AdminUserBaseDTO getCurrentUser(String username) {
        if(StringUtils.isBlank(username)){
            return null;
        }
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(AdminUser::getUsername,username);
        AdminUser adminUser = adminUserMapper.selectOne(queryWrapper);
        return adminUserConvert.convertToAdminUserBaseDTO(adminUser);
    }
}
