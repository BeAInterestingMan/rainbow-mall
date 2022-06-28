package com.rainbow.mall.auth.enums;

import java.util.Objects;

public enum LoginTypeEnum {

    APP("app","前台登录认证-走密码模式和授权码模式"),

    ADMIN("admin","pc后台认证-走密码模式")


    ;


    private final String name;

    private final String desc;

    LoginTypeEnum(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static LoginTypeEnum getByName(String name){
        for (LoginTypeEnum value : LoginTypeEnum.values()) {
             if(Objects.equals(value.name,name)){
                 return value;
             }
        }
        return LoginTypeEnum.ADMIN;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
