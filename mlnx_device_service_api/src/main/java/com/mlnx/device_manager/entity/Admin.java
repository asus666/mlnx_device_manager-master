package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mlnx.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@TableName("t_admin")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "管理员对象",description = "管理员对象admin")
public class Admin extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1938485410827112491L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "name",required = true,notes = "账号")
    private String account;
    @ApiModelProperty(value = "password",required = true,notes = "密码")
    private String password;


}
