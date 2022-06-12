package com.rainbow.mall.common.core.utils;

import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalUtil {

    public static BigDecimal convertToBigDecimal(Object value) {
        if(Objects.isNull(value)){
            return new BigDecimal("0");
        }
        return new BigDecimal(String.valueOf(value));
    }
}
