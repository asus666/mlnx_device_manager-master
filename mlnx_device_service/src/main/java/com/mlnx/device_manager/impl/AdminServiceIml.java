package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.common.utils.ObjectValidUtil;
import com.mlnx.device_manager.api.AdminService;
import com.mlnx.device_manager.core.entity.ExceptionMsg;
import com.mlnx.device_manager.core.entity.MD5Util;
import com.mlnx.device_manager.entity.Admin;
import com.mlnx.device_manager.mappers.TAdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class AdminServiceIml implements AdminService {
    @Autowired
    private TAdminMapper tAdminMapper;


    @Override
    public Response login(String account, String password) {

        if (ObjectValidUtil.isInvalid(account, password)) {
            return new Response(ExceptionMsg.ParamError);
        }

        Admin admin = tAdminMapper.selectOne(new QueryWrapper<Admin>().
                eq("account", account).last("limit 1"));
        String md5Pwd= MD5Util.string2MD5(password);
        if(ObjectValidUtil.isInvalid(admin)){
            return new ResponseData("管理员账号错误");
        }
        if(!(admin.getPassword().equals(md5Pwd))){
            return new ResponseData("密码不正确");
        }
        return new ResponseData(admin);
    }

    @Override
    public int insert(Admin admin) {
        String md5Password= MD5Util.string2MD5(admin.getPassword());
        admin.setPassword(md5Password);
        return tAdminMapper.insert(admin);
    }

    @Override
    public Admin selectById(Integer id) {
        return tAdminMapper.selectById(id);
    }

    @Override
    public Admin selectOne(Wrapper queryWrapper) {
        return tAdminMapper.selectOne(null);
    }

    @Override
    public List<Admin> selectList(Wrapper wrapper) {
        return tAdminMapper.selectList(null);
    }

    @Override
    public int deleteById(Integer id) {
        return tAdminMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tAdminMapper.delete(null);
    }

    @Override
    public int updateById(Admin admin) {
        return tAdminMapper.updateById(admin);
    }

    @Override
    public int update(Admin admin, Wrapper wrapper) {
        return tAdminMapper.update(admin,null);
    }
}
