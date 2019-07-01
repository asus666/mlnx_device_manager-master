package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.LifeCycle;

public interface TLifeCycleMapper extends BaseMapper<LifeCycle> {
    Page<LifeCycle> selectList(IPage<LifeCycle> page, Integer id);
}
