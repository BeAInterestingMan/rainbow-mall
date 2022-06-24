package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  UserRoleRepository {

    @Autowired
    private UserRoleMapper userRoleMapper;
	
}
