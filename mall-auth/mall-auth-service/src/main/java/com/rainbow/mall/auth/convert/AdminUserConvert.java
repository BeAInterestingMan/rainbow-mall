package com.rainbow.mall.auth.convert;

import com.rainbow.mall.auth.pojo.base.AdminUserBaseDTO;
import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;
import com.rainbow.mall.auth.pojo.entity.AdminUser;
import com.rainbow.mall.auth.pojo.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminUserConvert {

    AdminUserBaseDTO convertToAdminUserBaseDTO(AdminUser adminUser);
}
