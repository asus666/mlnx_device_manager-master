package com.mlnx.device_manager.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

public enum StateType implements IEnum {
    RETURNED(1,"已返厂"),
    FIXED(2,"维修中"),
    DONE(3,"已解决"),
    UNDONE(4,"未解决");
    private Integer num;
    private String state;

    private StateType(Integer num,String state){
        this.num=num;
        this.state=state;
    }

    @Override
    public Serializable getValue() {
        return null;
    }

    public String getState() {
        return state;
    }

    public Integer getNum() {
        return num;
    }
    public static StateType getByNum(Integer num) {
        for (StateType ftype : StateType.values()) {
            if (ftype.num.equals(num)) {
                return ftype;
            }
        }
        return null;
    }
    //根据value得到type值
    public static String getTypeByNum(Integer num) {
        return getByNum(num).state;
    }
}
