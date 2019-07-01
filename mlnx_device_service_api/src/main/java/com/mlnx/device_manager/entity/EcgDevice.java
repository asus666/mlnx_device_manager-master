package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mlnx.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

@TableName("t_ecg_device")
public class EcgDevice extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7474791925402596027L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String EcgDeviceRunMode;
    private String EcgChannelType;
    private String cpuid;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEcgDeviceRunMode() {
        return EcgDeviceRunMode;
    }

    public void setEcgDeviceRunMode(String ecgDeviceRunMode) {
        EcgDeviceRunMode = ecgDeviceRunMode;
    }

    public String getEcgChannelType() {
        return EcgChannelType;
    }

    public void setEcgChannelType(String ecgChannelType) {
        EcgChannelType = ecgChannelType;
    }

    public String getCpuid() {
        return cpuid;
    }

    public void setCpuid(String cpuid) {
        this.cpuid = cpuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EcgDevice ecgDevice = (EcgDevice) o;
        return Objects.equals(id, ecgDevice.id) &&
                Objects.equals(EcgDeviceRunMode, ecgDevice.EcgDeviceRunMode) &&
                Objects.equals(EcgChannelType, ecgDevice.EcgChannelType) &&
                Objects.equals(cpuid, ecgDevice.cpuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, EcgDeviceRunMode, EcgChannelType, cpuid);
    }

    @Override
    public String toString() {
        return "EcgDevice{" +
                "id=" + id +
                ", EcgDeviceRunMode='" + EcgDeviceRunMode + '\'' +
                ", EcgChannelType='" + EcgChannelType + '\'' +
                ", cpuid='" + cpuid + '\'' +
                '}';
    }
}
