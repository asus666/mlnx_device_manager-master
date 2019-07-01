package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.api.PushDetailService;
import com.mlnx.device_manager.entity.PushDetail;
import com.mlnx.device_manager.mappers.TPushDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushDetailServiceIml implements PushDetailService {
    @Autowired
    private TPushDetailMapper tPushDetailMapper;

    @Override
    public int insert(PushDetail pushDetail) {
        return tPushDetailMapper.insert(pushDetail);
    }

    @Override
    public PushDetail selectById(Integer id) {
        return tPushDetailMapper.selectById(id);
    }

    @Override
    public PushDetail selectOne(Wrapper queryWrapper) {
        return tPushDetailMapper.selectOne(null);
    }

    @Override
    public List<PushDetail> selectList(Wrapper wrapper) {
        return tPushDetailMapper.selectList(null);
    }

    @Override
    public int deleteById(Integer id) {
        return tPushDetailMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tPushDetailMapper.delete(null);
    }

    @Override
    public int updateById(PushDetail pushDetail) {
        return tPushDetailMapper.updateById(pushDetail);
    }

    @Override
    public int update(PushDetail pushDetail, Wrapper wrapper) {
        return tPushDetailMapper.update(pushDetail,null);
    }
}
