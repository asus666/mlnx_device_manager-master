
package com.mlnx.device_manager.core.entity;

import com.mlnx.common.entity.BaseExceptionMsg;

public enum ExceptionMsg implements BaseExceptionMsg {
    SUCCESS("0000", "操作成功"),
    FAILED("999999", "操作失败"),

    ParamError("000001", "参数错误！"),
    NoDevice("000002","此合同无相应设备"),
    DupName("000003","该号码已被注册"),
    //  失败(02开始标示DB操作相关错误码)
    DB_FAIL("000100", "数据库操作失败"),

//    OutinRecordServiceERROR1("000200", "库存不足"),
//    OutinRecordNotExist("000201", "库存不存在"),


    ;

    private ExceptionMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

