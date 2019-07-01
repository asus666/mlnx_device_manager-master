package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.api.DeviceTypeService;
import com.mlnx.device_manager.entity.DeviceType;
import com.mlnx.device_manager.mappers.TDeviceTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceTypeServiceIml implements DeviceTypeService {
    @Autowired
    private TDeviceTypeMapper tDeviceTypeMapper;

    @Override
    public List<DeviceType> selectDTC() {
        return tDeviceTypeMapper.selectDTC();
    }

    @Override
    public int insert(DeviceType deviceType) {
        return tDeviceTypeMapper.insert(deviceType);
    }

    @Override
    public DeviceType selectById(Integer id) {
        return tDeviceTypeMapper.selectById(id);
    }

    @Override
    public DeviceType selectOne(Wrapper queryWrapper) {
        return tDeviceTypeMapper.selectOne(null);
    }

    //@Override
    //public List<DeviceType> selectList(Wrapper wrapper) {
    //    return tDeviceTypeMapper.selectList(null);
    //}

    @Override
    public int deleteById(Integer id) {
        return tDeviceTypeMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tDeviceTypeMapper.delete(null);
    }

    @Override
    public int updateById(DeviceType deviceType) {
        return tDeviceTypeMapper.updateById(deviceType);
    }

    @Override
    public int update(DeviceType deviceType, Wrapper wrapper) {
        return tDeviceTypeMapper.update(deviceType,null);
    }
}
