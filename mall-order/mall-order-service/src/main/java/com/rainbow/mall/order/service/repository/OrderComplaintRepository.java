package com.rainbow.mall.order.service.repository;

import com.rainbow.mall.order.service.mapper.OrderComplaintMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  OrderComplaintRepository {

    @Autowired
    private OrderComplaintMapper orderComplaintMapper;
	
}
