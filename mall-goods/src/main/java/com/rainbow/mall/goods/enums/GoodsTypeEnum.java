package com.rainbow.mall.goods.enums;


import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public enum GoodsTypeEnum {

    /**
     * "实物商品"
     */
    PHYSICAL_GOODS("实物商品","PHYSICAL_GOODS"),
    /**
     * "虚拟商品"
     */
    VIRTUAL_GOODS("虚拟商品","VIRTUAL_GOODS"),
    /**
     * "电子卡券"
     */
    E_COUPON("电子卡券","E_COUPON");


    private final String description;

    private final String value;

    GoodsTypeEnum(String description, String value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    public static GoodsTypeEnum getByValue(String value){
        if(StringUtils.isBlank(value)){
            return null;
        }
        for (GoodsTypeEnum goodsTypeEnum : GoodsTypeEnum.values()) {
            if(Objects.equals(goodsTypeEnum.value,value)){
                return goodsTypeEnum;
            }
        }
        return null;
    }

}
