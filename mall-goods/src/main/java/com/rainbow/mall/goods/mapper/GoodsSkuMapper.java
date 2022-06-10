package com.rainbow.mall.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rainbow.mall.goods.entity.GoodsSku;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
public interface GoodsSkuMapper extends BaseMapper<GoodsSku> {
	
}
