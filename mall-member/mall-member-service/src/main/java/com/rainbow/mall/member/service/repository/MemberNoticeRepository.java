package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberNoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberNoticeRepository {

    @Autowired
    private MemberNoticeMapper memberNoticeMapper;
	
}
