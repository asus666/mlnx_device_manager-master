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

/**
 * Created by amanda.shan on 2019/1/30.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@TableName("t_user")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "医院对象",description = "医院对象user")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6810633052077437419L;
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    @ApiModelProperty(value = "name",required = true,notes = "医院登陆账号(手机号码)")
    private String name;
    @ApiModelProperty(value = "password",required = true,notes = "密码")
    private String password;
    @ApiModelProperty(value = "linkman",required = true,notes = "联系人")
    private String linkman;
    @ApiModelProperty(value = "hospitalName",required = true,notes = "医院名称")
    private String hospitalName;
    @ApiModelProperty(value = "address",required = true,notes = "地址")
    private String address;
    @ApiModelProperty(value = "dealerId",required = true,notes = "所属经销商id")
    private Integer dealerId;
    @ApiModelProperty(value = "bpPushId",allowEmptyValue = true,required = true,notes = "血压推送",example = "123")
    private Integer bpPushId;
    @ApiModelProperty(value = "bsPushId",allowEmptyValue = true,required = true,notes = "心电推送",example = "123")
    private Integer bsPushId;
    @ApiModelProperty(value = "isnative",allowableValues = "是(本地)，否(远程)",required = true,notes = "是否远程")
    private String isnative;

}
