package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.entity.PushRecord;

import java.util.List;

public interface PushRecordService {
    int insert(PushRecord pushRecord);
    PushRecord selectById(Integer id);
    PushRecord selectOne(Wrapper queryWrapper);
    List<PushRecord> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(PushRecord pushRecord);
    int update(PushRecord pushRecord, Wrapper wrapper);
}
