package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberEvaluationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberEvaluationRepository {

    @Autowired
    private MemberEvaluationMapper memberEvaluationMapper;
	
}
