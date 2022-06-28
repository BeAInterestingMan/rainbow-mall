package com.rainbow.mall.goods.service.repository;

import com.alibaba.fastjson.JSON;
import com.rainbow.mall.common.core.enums.CommonRedisEnums;
import com.rainbow.mall.common.redis.helper.RedisHelper;
import com.rainbow.mall.goods.service.convert.GoodsCartConvert;
import com.rainbow.mall.goods.service.pojo.dto.base.GoodsCartBaseDTO;
import com.rainbow.mall.goods.service.pojo.dto.service.cart.GoodsCartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Repository
public class GoodsCartRepository {

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private GoodsCartConvert goodsCartConvert;

    public void save(GoodsCartBaseDTO goodsCartBaseDTO) {
        // TODO 用户token
        String key = CommonRedisEnums.GOODS_CART_PREFIX+"122333";
        redisHelper.hSet(key,goodsCartBaseDTO.getSkuId(),JSON.toJSONString(goodsCartBaseDTO));
    }

    /**
     * @Description 获取购物车详情数据
     * @author liuhu
     * @date 2022/6/27 15:38
     * @return com.rainbow.mall.goods.service.pojo.dto.base.GoodsCartBaseDTO
     */
    public List<GoodsCartBaseDTO> getUserCartInfo() {
        List<GoodsCartBaseDTO> list = new ArrayList<>();
        String key = CommonRedisEnums.GOODS_CART_PREFIX+"122333";
        Map<Object, Object> map = redisHelper.hGetAll(key);
        if(Objects.isNull(map) || map.isEmpty()){
            return null;
        }
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            list.add(JSON.parseObject(JSON.toJSONString(entry.getValue()),GoodsCartBaseDTO.class));
        }
        return list;
    }

    public void clean() {
        String key = CommonRedisEnums.GOODS_CART_PREFIX+"122333";
        redisHelper.del(key);
    }

    public void delete(String skuId) {
        String key = CommonRedisEnums.GOODS_CART_PREFIX+"122333";
        redisHelper.hDelete(key,skuId);
    }
}
