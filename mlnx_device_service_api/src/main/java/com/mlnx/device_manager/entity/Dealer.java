package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mlnx.common.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@TableName("t_dealer")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "经销商对象",description = "经销商对象dealer")
public class Dealer extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 580274908459940146L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "phone",required = true,notes = "手机号")
    private String phone;
    @ApiModelProperty(value = "password",required = true,notes = "密码")
    private String password;
    @ApiModelProperty(value = "linkman",required = true,notes = "联系人")
    private String linkman;
    @ApiModelProperty(value = "dealerName",required = true,notes = "经销商")
    private String dealerName;
    @ApiModelProperty(value = "address",required = true,notes = "地址")
    private String address;


}