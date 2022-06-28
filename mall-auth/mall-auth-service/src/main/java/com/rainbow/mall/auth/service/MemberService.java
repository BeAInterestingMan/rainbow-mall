package com.rainbow.mall.auth.service;

import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;

public interface MemberService {
    MemberBaseDTO getByPhone(String idCard);
}
