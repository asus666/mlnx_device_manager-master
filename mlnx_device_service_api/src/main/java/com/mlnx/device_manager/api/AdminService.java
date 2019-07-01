package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.mlnx.common.entity.Response;
import com.mlnx.device_manager.entity.Admin;

import java.util.List;

public interface AdminService {
    int insert(Admin admin);
    Admin selectById(Integer id);
    Admin selectOne(Wrapper queryWrapper);
    List<Admin> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(Admin admin);
    int update(Admin admin, Wrapper wrapper);
    Response login(String account, String password);
}
