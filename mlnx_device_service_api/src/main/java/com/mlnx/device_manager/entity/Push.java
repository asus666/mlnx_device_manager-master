package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mlnx.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

@TableName("t_push")
public class Push extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4446636075143059721L;
    @TableId(type= IdType.AUTO)
    private Integer id;
    private Integer pushTypeId;
    private String ip;
    private String port;
    private String url;
    private Integer inUse;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPushTypeId() {
        return pushTypeId;
    }

    public void setPushTypeId(Integer pushTypeId) {
        this.pushTypeId = pushTypeId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getInUse() {
        return inUse;
    }

    public void setInUse(Integer inUse) {
        this.inUse = inUse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Push push = (Push) o;
        return Objects.equals(id, push.id) &&
                Objects.equals(pushTypeId, push.pushTypeId) &&
                Objects.equals(ip, push.ip) &&
                Objects.equals(port, push.port) &&
                Objects.equals(url, push.url) &&
                Objects.equals(inUse, push.inUse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pushTypeId, ip, port, url, inUse);
    }

    @Override
    public String toString() {
        return "Push{" +
                "id=" + id +
                ", pushTypeId=" + pushTypeId +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", url='" + url + '\'' +
                ", inUse=" + inUse +
                '}';
    }
}
