package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberRepository {

    @Autowired
    private MemberMapper memberMapper;
	
}
