package com.rainbow.mall.common.core.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

public class SnowFlakeUtil {

    public static long snowflakeId(){
        Snowflake snowflake = IdUtil.getSnowflake();
        return snowflake.nextId();
    }

}
