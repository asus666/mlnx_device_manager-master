package com.mlnx.device_manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mlnx.common.entity.BaseEntity;

import java.io.Serializable;
import java.util.Objects;

@TableName("t_push_type")
public class PushRecord extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 793278715824335136L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String pushType;
    private String description;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getPushType() {
        return pushType;
    }

    public void setPushType(String pushType) {
        this.pushType = pushType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PushRecord that = (PushRecord) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(pushType, that.pushType) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pushType, description);
    }

    @Override
    public String toString() {
        return "PushRecord{" +
                "id=" + id +
                ", pushType='" + pushType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
