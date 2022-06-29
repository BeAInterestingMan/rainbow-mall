package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberStatisticsDataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberStatisticsDataRepository {

    @Autowired
    private MemberStatisticsDataMapper memberStatisticsDataMapper;
	
}
