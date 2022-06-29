package com.rainbow.mall.member.service.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 19:19:50
 */
@Repository
public class  MemberRepository {

    @Autowired
    private  MemberMapper  memberMapper;
	
}
