package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberMessageRepository {

    @Autowired
    private MemberMessageMapper memberMessageMapper;
	
}
