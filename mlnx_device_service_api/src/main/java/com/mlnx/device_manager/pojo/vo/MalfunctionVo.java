package com.mlnx.device_manager.pojo.vo;

import com.mlnx.device_manager.entity.DeviceMalfunction;
import lombok.Data;

@Data
public class MalfunctionVo extends DeviceMalfunction {
    private static final long serialVersionUID = 1489657727804854114L;
    private String numeration;
}
