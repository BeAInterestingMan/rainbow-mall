package com.rainbow.mall.order.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbow.mall.order.service.pojo.entity.Order;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderMapper extends BaseMapper<Order> {
	
}
