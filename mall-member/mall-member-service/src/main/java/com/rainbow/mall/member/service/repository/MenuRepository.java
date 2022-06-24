package com.rainbow.mall.member.service.repository;

import com.rainbow.mall.member.service.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  MenuRepository {

    @Autowired
    private MenuMapper menuMapper;
	
}
