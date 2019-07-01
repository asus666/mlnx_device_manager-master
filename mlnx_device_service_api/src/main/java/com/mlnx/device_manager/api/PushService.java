package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.entity.Push;

import java.util.List;

public interface PushService {
    int insert(Push push);
    Push selectById(Integer id);
    Push selectOne(Wrapper queryWrapper);
    List<Push> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(Push push);
    int update(Push push, Wrapper wrapper);
}
