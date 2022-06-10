package com.rainbow.mall.common.redis.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;
/**
 *  @Description redis工具类
 *  @author liuhu
 *  @Date 2022/5/14 15:48
 */
public class RedisHelper {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public Boolean set(String key, Object value, Long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean set(String key, Object value, Long time,TimeUnit timeUnit) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, timeUnit);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }


    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return true-存在，false-不存在
     */
    public boolean hasKey(String key) {
        Boolean res = redisTemplate.hasKey(key);
        if (null == res) {
            return false;
        }
        return res;
    }


    public Boolean expire(String key, Long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void del(String key) {
        redisTemplate.delete(key);
    }
}
