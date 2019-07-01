package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.device_manager.entity.LifeCycle;


public interface LifeCycleService {
    int insert(LifeCycle lifeCycle);
    IPage<LifeCycle> selectList(IPage<LifeCycle> page, Integer id);
    LifeCycle selectOne(Wrapper queryWrapper);
}
