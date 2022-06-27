package com.rainbow.mall.common.core.enums;

public enum CommonRedisEnums {

    GOODS_CART_PREFIX("GOODS_CART_PREFIX:","购物车前缀");

    ;

    private final String prefix;

    private final String desc;

    CommonRedisEnums(String prefix, String desc) {
        this.prefix = prefix;
        this.desc = desc;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDesc() {
        return desc;
    }
}
