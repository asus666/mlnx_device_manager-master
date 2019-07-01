package com.mlnx.device_manager.pojo.vo;

import com.mlnx.device_manager.entity.User;
import lombok.Data;

@Data
public class UserVo extends User {
    private static final long serialVersionUID = -4497665240109072507L;
    private String dealerName;
}
