package com.mlnx.device_manager.pojo.vo;

import com.mlnx.device_manager.entity.Device;
import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceVo extends Device implements Serializable {
    private static final long serialVersionUID = 8395529031351459886L;
    private String dealerName;
    private String hospitalName;
    private String producerName;
    private String name;
}
