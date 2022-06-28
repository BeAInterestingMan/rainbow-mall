package com.rainbow.mall.auth.service.impl;

import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;
import com.rainbow.mall.auth.repository.MemberRepository;
import com.rainbow.mall.auth.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public MemberBaseDTO getByPhone(String phone) {
       return memberRepository.getByPhone(phone);
    }
}
