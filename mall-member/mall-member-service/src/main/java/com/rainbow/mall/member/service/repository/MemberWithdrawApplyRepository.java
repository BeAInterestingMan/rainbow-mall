package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberWithdrawApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberWithdrawApplyRepository {

    @Autowired
    private MemberWithdrawApplyMapper memberWithdrawApplyMapper;
	
}
