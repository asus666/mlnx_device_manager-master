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

@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@TableName("t_lifecycle")
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "生命周期对象",description = "生命周期对象lifeCycle")
//当使用@Data注解时，则有了@EqualsAndHashCode注解，
//那么就会在此类中存在equals(Object other) 和 hashCode()方法，且不会使用父类的属性，
//解决办法：在使用@Data时同时加上@EqualsAndHashCode(callSuper=true)注解。
public class LifeCycle extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2378481827319176639L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
   @ApiModelProperty(value = "deviceId",required = true,notes = "设备id",example = "123")
    private Integer deviceId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "endPoint",required = true,notes = "事件日期")
    private Date endPoint;
    @ApiModelProperty(value = "event",required = true,notes = "事件")
    private String event;
   @ApiModelProperty(value = "remark",required = true,notes = "备注")
    private String remark;
}
