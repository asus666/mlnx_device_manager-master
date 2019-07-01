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
@ApiModel(value = "设备对象",description = "设备对象device")
@TableName("t_device")
@Data
@EqualsAndHashCode(callSuper=true)
public class Device extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 3219308989429336711L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "numeration",required = true,notes = "设备编号(唯一)")
    private String numeration;
    @ApiModelProperty(value = "mcuId",required = true,notes = "mcuId(唯一)")
    private String mcuId;
    @ApiModelProperty(value = "macAddress",required = true,notes = "mac地址(唯一)")
    private String macAddress;
    @ApiModelProperty(value = "deviceTypeId",allowableValues = "1(血压) 2(血糖) 3(心电)",required = true,notes = "设备类型",example = "123")
    private Integer deviceTypeId;
    @ApiModelProperty(value = "patientId",allowEmptyValue = true,required = true,notes = "病人序号",example = "123")
    private Integer patientId;
    //1:蓝牙 2:无线 3:GPRS
    @ApiModelProperty(value = "transmissionType",allowableValues = "1(蓝牙设备传输) 2(无线设备传输) 3(GPRS设备传输)",required = true,notes = "传输类型")
    private String transmissionType;
    @ApiModelProperty(value = "producerId",required = true,notes = "制造商序号",example = "123")
    private Integer producerId;
    @ApiModelProperty(value = "dealerId",required = true,notes = "经销商序号",example = "123")
    private Integer dealerId;
    @ApiModelProperty(value = "contractId",allowEmptyValue = true,required = true,notes = "合同id",example = "123")
    private Integer contractId;
    @ApiModelProperty(value = "hospitalId",required = true,notes = "医院序号",example = "123")
    private Integer hospitalId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "productionTime",required = true,notes = "制造时间")
    private Date productionTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "durableTime",required = true,notes = "有效时间")
    private Date durableTime;
    @ApiModelProperty(value = "state",allowEmptyValue = true,required = true,notes = "是否可用",example = "123")
    private Integer state;


}