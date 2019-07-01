package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mlnx.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@TableName("t_push_detail")
public class PushDetail extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 2667570301568294260L;
    @TableId(type=IdType.AUTO)
    private Integer id;
    private String messageId;
    private Date pushTime;
    private String responseMsg;
    private String responseCode;
    private Integer pushStatus;
    private String pushType;
    private String ip;
    private String port;
    private String url;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public Integer getPushStatus() {
        return pushStatus;
    }

    public void setPushStatus(Integer pushStatus) {
        this.pushStatus = pushStatus;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PushDetail that = (PushDetail) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(messageId, that.messageId) &&
                Objects.equals(pushTime, that.pushTime) &&
                Objects.equals(responseMsg, that.responseMsg) &&
                Objects.equals(responseCode, that.responseCode) &&
                Objects.equals(pushStatus, that.pushStatus) &&
                Objects.equals(pushType, that.pushType) &&
                Objects.equals(ip, that.ip) &&
                Objects.equals(port, that.port) &&
                Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageId, pushTime, responseMsg, responseCode, pushStatus, pushType, ip, port, url);
    }

    @Override
    public String toString() {
        return "PushDetail{" +
                "id=" + id +
                ", messageId='" + messageId + '\'' +
                ", pushTime=" + pushTime +
                ", responseMsg='" + responseMsg + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", pushStatus=" + pushStatus +
                ", pushType='" + pushType + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
