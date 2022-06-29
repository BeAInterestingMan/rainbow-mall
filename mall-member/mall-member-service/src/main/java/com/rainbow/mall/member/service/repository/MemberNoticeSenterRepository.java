package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberNoticeSenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberNoticeSenterRepository {

    @Autowired
    private MemberNoticeSenterMapper memberNoticeSenterMapper;
	
}
