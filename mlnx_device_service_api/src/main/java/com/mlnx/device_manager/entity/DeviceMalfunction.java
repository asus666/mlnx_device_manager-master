package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mlnx.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@TableName("t_device_malfunction")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "设备故障对象",description = "设备故障对象deviceMalfuncation")
public class DeviceMalfunction extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2116262023104288376L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "deviceId",required = true,notes = "设备序号",example = "123")
    private Integer deviceId;
    @ApiModelProperty(value = "malfunction",required = true,notes = "故障原因")
    private String malfunction;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "backDate",required = true,notes = "返厂时间")
    private Date backDate;
    @ApiModelProperty(value = "remark",required = true,notes = "备注")
    private String remark;
    @ApiModelProperty(value = "stateId",required = true,allowableValues ="1(已返厂) 2(维修中) 3(已解决) 4(未解决)" ,notes = "状态")
    private String state;


}
