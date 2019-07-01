package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mlnx.device_manager.entity.DeviceType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TDeviceTypeMapper extends BaseMapper<DeviceType> {
    @Select("select t.id,(case name when 'BP_DEVICE' then '血压设备'when 'SPO_DEVICE' then '血糖设备'when 'ECG_DEVICE' then '心电设备'when 'MP_DEVICE' then '心电多参设备'else '空的' end)name  from t_device_type t")
    List<DeviceType> selectDTC();

}
