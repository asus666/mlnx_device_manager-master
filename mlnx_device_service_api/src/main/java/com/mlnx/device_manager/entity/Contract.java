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
@TableName("t_contract")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "合同对象",description = "合同对象contract")
public class Contract  extends BaseEntity implements Serializable{
    private static final long serialVersionUID = -3776825297000695601L;
    @TableId(type= IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "numeration",required = true,notes = "合同编号，唯一")
    private String numeration;
    @ApiModelProperty(value = "dealerId",allowEmptyValue = true,notes = "相关经销商id",example = "123")
    private Integer dealerId;
    @ApiModelProperty(value = "hospitalId",allowEmptyValue = true,notes = "相关医院id",example = "123")
    private Integer hospitalId;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @ApiModelProperty(value = "deliverDate",required = true,notes = "合同签订发货时间")
    private Date deliverDate;
    @ApiModelProperty(value = "signer",required = true,notes = "签订人")
    private String signer;
    @ApiModelProperty(value = "remark",required = true,notes = "备注")
    private String remark;


}
