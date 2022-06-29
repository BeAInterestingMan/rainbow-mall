package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberWalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberWalletRepository {

    @Autowired
    private MemberWalletMapper memberWalletMapper;
	
}
