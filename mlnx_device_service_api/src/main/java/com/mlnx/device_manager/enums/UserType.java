package com.mlnx.device_manager.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

public enum UserType implements IEnum {
    HOSPITAL(0,"医院"),
    DEALER(1,"经销商");


    private Integer value;
    private String type;

    private UserType(Integer value, String type) {
        this.value=value;
        this.type=type;
    }

    @Override
    public Serializable getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    //根据value得到枚举实例
    public static UserType getByCode(Integer value) {
        UserType defaultType = UserType.HOSPITAL;
        for (UserType ftype : UserType.values()) {
            if (ftype.value == value) {
                return ftype;
            }
        }
        return defaultType;
    }

    //根据value得到type值
    public static String getTypeByCode(Integer value) {
        return getByCode(value).type;
    }
}
