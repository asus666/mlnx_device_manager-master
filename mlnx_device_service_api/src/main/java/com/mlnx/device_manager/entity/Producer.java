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
@TableName("t_producer")
@Data
@EqualsAndHashCode(callSuper=true)
@ApiModel(value = "生产者对象",description = "生产者对象producer")
public class Producer extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 5990138408884388649L;
    @TableId(type=IdType.AUTO)
    @ApiModelProperty(value = "id",required = true,example = "123")
    private Integer id;
    //生产商名称
    @ApiModelProperty(value = "name",required = true,notes = "制造商名称")
    private String name;
    @ApiModelProperty(value = "linkman",required = true,notes = "联系人")
    private String linkman;
    @ApiModelProperty(value = "phone",required = true,notes = " 联系电话")
    private String phone;
    @ApiModelProperty(value = "address",required = true,notes = "地址")
    private String address;


}
