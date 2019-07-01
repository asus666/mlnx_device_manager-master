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

@TableName("t_device_type")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "设备类型对象",description = "设备类型对象deviceType")
public class DeviceType extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 6713956227336283834L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "name",required = true,notes = "设备类型")
    private String name;


}
