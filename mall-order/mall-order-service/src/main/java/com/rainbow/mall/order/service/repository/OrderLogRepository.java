package com.rainbow.mall.order.service.repository;

import com.rainbow.mall.order.service.mapper.OrderLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  OrderLogRepository {

    @Autowired
    private OrderLogMapper orderLogMapper;
	
}
