package com.rainbow.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbow.mall.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
public interface GoodsMapper extends BaseMapper<Goods> {
	
}