package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberAddressRepository {

    @Autowired
    private MemberAddressMapper memberAddressMapper;
	
}
