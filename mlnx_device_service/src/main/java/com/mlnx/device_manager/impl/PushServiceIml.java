package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.api.PushService;
import com.mlnx.device_manager.entity.Push;
import com.mlnx.device_manager.mappers.TPushMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushServiceIml implements PushService {
    @Autowired
    private TPushMapper tPushMapper;
    @Override
    public int insert(Push push) {
        return tPushMapper.insert(push);
    }

    @Override
    public Push selectById(Integer id) {
        return tPushMapper.selectById(id);
    }

    @Override
    public Push selectOne(Wrapper queryWrapper) {
        return tPushMapper.selectOne(null);
    }

    @Override
    public List<Push> selectList(Wrapper wrapper) {
        return tPushMapper.selectList(null);
    }

    @Override
    public int deleteById(Integer id) {
        return tPushMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tPushMapper.delete(null);
    }

    @Override
    public int updateById(Push push) {
        return tPushMapper.updateById(push);
    }

    @Override
    public int update(Push push, Wrapper wrapper) {
        return tPushMapper.update(push,null);
    }
}
