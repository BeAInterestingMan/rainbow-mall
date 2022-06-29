package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberNoticeLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberNoticeLogRepository {

    @Autowired
    private MemberNoticeLogMapper memberNoticeLogMapper;
	
}
