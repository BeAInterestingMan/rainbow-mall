package com.rainbow.mall.goods.repository;

import com.rainbow.mall.goods.mapper.GoodsUnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *  @Description  
 *  @author liuhu
 *  @Date 2022-06-09 18:55:46
 */
@Repository
public class  GoodsUnitRepository {

    @Autowired
    private GoodsUnitMapper goodsUnitMapper;
	
}
