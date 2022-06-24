package com.rainbow.mall.order.service.repository;

import com.rainbow.mall.order.service.mapper.OrderComplaintCommunicationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class  OrderComplaintCommunicationRepository {

    @Autowired
    private OrderComplaintCommunicationMapper orderComplaintCommunicationMapper;
	
}
