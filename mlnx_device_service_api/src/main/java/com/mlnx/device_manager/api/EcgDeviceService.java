package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.entity.EcgDevice;

import java.util.List;

public interface EcgDeviceService {
    int insert(EcgDevice ecgDevice);
    EcgDevice selectById(Integer id);
    EcgDevice selectOne(Wrapper queryWrapper);
    List<EcgDevice> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(EcgDevice ecgDevice);
    int update(EcgDevice ecgDevice, Wrapper wrapper);
}
