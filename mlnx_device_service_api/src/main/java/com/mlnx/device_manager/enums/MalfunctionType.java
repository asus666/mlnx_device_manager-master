package com.mlnx.device_manager.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

public enum MalfunctionType implements IEnum {
    FACADE(1,"外观故障"),
    RESERVE(2,"储存故障"),
    WIRE(3,"导联故障"),
    SIGNAL(4,"信号故障"),
    SOFTWARE(5,"软件故障"),
    PARTS(6,"配件故障"),
    OTHER(7,"其他故障");

    private Integer num;
    private String type;

    private MalfunctionType(Integer num,String type){
        this.num=num;
        this.type=type;
    }

    public Integer getNum() {
        return num;
    }

    public String getType() {
        return type;
    }

    @Override
    public Serializable getValue() {
        return null;
    }
    //根据value得到枚举实例
    public static MalfunctionType getByNum(Integer num) {
         for (MalfunctionType ftype : MalfunctionType.values()) {
            if (ftype.num.equals(num)) {
            return ftype;
        }
    }
        return null;
     }

    //根据value得到type值
    public static String getTypeByNum(Integer num) {
      return getByNum(num).type;
    }
}
