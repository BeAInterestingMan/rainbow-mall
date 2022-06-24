package com.rainbow.mall.order.service.repository;

import com.rainbow.mall.order.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  OrderRepository {

    @Autowired
    private OrderMapper orderMapper;
	
}
