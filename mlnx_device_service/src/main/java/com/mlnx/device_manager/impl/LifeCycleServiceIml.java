package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.device_manager.api.LifeCycleService;
import com.mlnx.device_manager.entity.LifeCycle;
import com.mlnx.device_manager.mappers.TLifeCycleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LifeCycleServiceIml implements LifeCycleService {
    @Autowired
    private TLifeCycleMapper tLifeCycleMapper;
    @Override
    public IPage<LifeCycle> selectList(IPage<LifeCycle> page, Integer id) {
        return tLifeCycleMapper.selectList(page,id);
    }

    @Override
    public int insert(LifeCycle lifeCycle) {
        return tLifeCycleMapper.insert(lifeCycle);
    }

    @Override
    public LifeCycle selectOne(Wrapper queryWrapper) {
        return tLifeCycleMapper.selectOne(queryWrapper);
    }
}
