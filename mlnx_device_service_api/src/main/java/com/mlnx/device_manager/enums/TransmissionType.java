package com.mlnx.device_manager.enums;


import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

public enum TransmissionType implements IEnum {
    BLUETOOTH(1,"蓝牙设备传输"),
    WIFI(2,"无线设备传输"),
    GPRS(3,"GPRS设备传输");
    private Integer num;
    private String type;
    private TransmissionType(Integer num,String type){
        this.num=num;
        this.type=type;
    }
    //@JsonValue
    public String getType() {
        return type;
   }

    public Integer getNum() {
        return num;
    }

    @Override
    public Serializable getValue() {
        return null;
    }


    //根据value得到枚举实例
    public static TransmissionType getByNum(Integer num) {
        for (TransmissionType ftype : TransmissionType.values()) {
            if (ftype.num.equals(num)) {
                return ftype;
            }
        }
        return null;
    }

    //根据value得到type值
    //public static String getTypeByCode(Integer value) {
      //  return getByCode(value).type;
    //}
}
