package com.rainbow.mall.member.service.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbow.mall.member.service.mapper.RoleMenuMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class  RoleMenuRepository {

    @Autowired
    private RoleMenuMapper roleMenuMapper;
	
}
