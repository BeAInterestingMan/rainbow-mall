package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MemberGradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MemberGradeRepository {

    @Autowired
    private MemberGradeMapper memberGradeMapper;
	
}
