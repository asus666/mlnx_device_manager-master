package com.mlnx.device_manager.pojo.vo.form;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Objects;

@Data
public class DeviceForm implements Serializable {
    private static final long serialVersionUID = -2602552539878124549L;
    private Integer current;
    private Integer size;
    private String searchKey;
    private Integer malId;
    private Integer stateId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceForm that = (DeviceForm) o;
        return Objects.equals(current, that.current) &&
                Objects.equals(size, that.size) &&
                Objects.equals(searchKey, that.searchKey) &&
                Objects.equals(malId, that.malId) &&
                Objects.equals(stateId, that.stateId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(current, size, searchKey, malId, stateId);
    }


}
