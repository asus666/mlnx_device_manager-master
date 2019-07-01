package com.mlnx.device_manager.pojo.vo;

import com.mlnx.device_manager.entity.Contract;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper=true)
public class ContractVo extends Contract implements Serializable {

    private static final long serialVersionUID = 4001070872982951001L;
    private String dealerName;
    private String hospitalName;
    //private String deviceId;
    //private Integer count;
}
