package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.device_manager.entity.PushDetail;

import java.util.List;

public interface PushDetailService {
    int insert(PushDetail pushDetail);
    PushDetail selectById(Integer id);
    PushDetail selectOne(Wrapper queryWrapper);
    List<PushDetail> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(PushDetail pushDetail);
    int update(PushDetail pushDetail, Wrapper wrapper);
}
