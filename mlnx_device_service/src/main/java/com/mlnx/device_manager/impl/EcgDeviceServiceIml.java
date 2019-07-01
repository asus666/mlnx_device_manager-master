package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.api.EcgDeviceService;
import com.mlnx.device_manager.entity.EcgDevice;
import com.mlnx.device_manager.mappers.TEcgDeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcgDeviceServiceIml implements EcgDeviceService {
    @Autowired
    private TEcgDeviceMapper tEcgDeviceMapper;
    @Override
    public int insert(EcgDevice ecgDevice) {
        return tEcgDeviceMapper.insert(ecgDevice);
    }

    @Override
    public EcgDevice selectById(Integer id) {
        return tEcgDeviceMapper.selectById(id);
    }

    @Override
    public EcgDevice selectOne(Wrapper queryWrapper) {
        return tEcgDeviceMapper.selectOne(null);
    }

    @Override
    public List<EcgDevice> selectList(Wrapper wrapper) {
        return tEcgDeviceMapper.selectList(null);
    }

    @Override
    public int deleteById(Integer id) {
        return tEcgDeviceMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tEcgDeviceMapper.delete(null);
    }

    @Override
    public int updateById(EcgDevice ecgDevice) {
        return tEcgDeviceMapper.updateById(ecgDevice);
    }

    @Override
    public int update(EcgDevice ecgDevice, Wrapper wrapper) {
        return tEcgDeviceMapper.update(ecgDevice,null);
    }
}
