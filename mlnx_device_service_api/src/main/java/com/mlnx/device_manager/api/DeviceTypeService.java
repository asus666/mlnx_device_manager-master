package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.entity.DeviceType;

import java.util.List;

public interface DeviceTypeService {
    int insert(DeviceType deviceType);
    DeviceType selectById(Integer id);
    DeviceType selectOne(Wrapper queryWrapper);
    //List<DeviceType> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(DeviceType deviceType);
    int update(DeviceType deviceType, Wrapper wrapper);
    List<DeviceType> selectDTC();
}
