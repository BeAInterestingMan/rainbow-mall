package com.rainbow.mall.member.service.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbow.mall.member.service.mapper.MemberCouponMapper;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;


@Repository
public class  MemberCouponRepository {

    @Autowired
    private MemberCouponMapper memberCouponMapper;
	
}
