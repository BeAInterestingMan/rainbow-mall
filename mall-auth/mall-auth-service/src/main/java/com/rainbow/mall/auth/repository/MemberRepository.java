package com.rainbow.mall.auth.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.rainbow.mall.auth.convert.MemberConvert;
import com.rainbow.mall.auth.mapper.MemberMapper;
import com.rainbow.mall.auth.pojo.base.MemberBaseDTO;
import com.rainbow.mall.auth.pojo.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberRepository {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private MemberConvert memberConvert;

    public MemberBaseDTO getByPhone(String phone) {
        if(StringUtils.isBlank(phone)){
            return null;
        }
        LambdaQueryWrapper<Member> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Member::getMobile,phone);
        Member member = memberMapper.selectOne(queryWrapper);
        MemberBaseDTO memberBaseDTO = memberConvert.convertToMemberBaseDTO(member);
        return memberBaseDTO;
    }
}
