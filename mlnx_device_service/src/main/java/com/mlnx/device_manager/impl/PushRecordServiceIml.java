package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.api.PushRecordService;
import com.mlnx.device_manager.entity.PushRecord;
import com.mlnx.device_manager.mappers.TPushRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushRecordServiceIml implements PushRecordService {
    @Autowired
    private TPushRecordMapper tPushRecordMapper;
    @Override
    public int insert(PushRecord pushRecord) {
        return tPushRecordMapper.insert(pushRecord);
    }

    @Override
    public PushRecord selectById(Integer id) {
        return tPushRecordMapper.selectById(id);
    }

    @Override
    public PushRecord selectOne(Wrapper queryWrapper) {
        return tPushRecordMapper.selectOne(null);
    }

    @Override
    public List<PushRecord> selectList(Wrapper wrapper) {
        return tPushRecordMapper.selectList(null);
    }

    @Override
    public int deleteById(Integer id) {
        return tPushRecordMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tPushRecordMapper.delete(null);
    }

    @Override
    public int updateById(PushRecord pushRecord) {
        return tPushRecordMapper.updateById(pushRecord);
    }

    @Override
    public int update(PushRecord pushRecord, Wrapper wrapper) {
        return tPushRecordMapper.update(pushRecord,null);
    }
}
