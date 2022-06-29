package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberReceiptRepository {

    @Autowired
    private MemberReceiptMapper memberReceiptMapper;
	
}
