package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  RoleRepository {

    @Autowired
    private RoleMapper roleMapper;
	
}
