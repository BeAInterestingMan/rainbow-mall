package com.rainbow.mall.order.service.repository;

import com.rainbow.mall.order.service.mapper.OrderItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  OrderItemRepository {

    @Autowired
    private OrderItemMapper orderItemMapper;
	
}
