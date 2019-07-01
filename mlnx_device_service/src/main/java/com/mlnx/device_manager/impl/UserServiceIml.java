package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.common.utils.ObjectValidUtil;
import com.mlnx.device_manager.api.UserService;
import com.mlnx.device_manager.core.entity.ExceptionMsg;
import com.mlnx.device_manager.core.entity.MD5Util;
import com.mlnx.device_manager.entity.User;
import com.mlnx.device_manager.mappers.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by amanda.shan on 2019/1/30.
 */
@Service

public class UserServiceIml implements UserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public Response login(String name, String password) {
        if (ObjectValidUtil.isInvalid(name, password)) {
            return new Response(ExceptionMsg.ParamError);
        }
        String md5Pwd= MD5Util.string2MD5(password);
        User user = tUserMapper.selectOne(new QueryWrapper<User>().select("id","hospital_name","password").eq("name",name));

        if(name.matches("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")){

            if(ObjectValidUtil.isInvalid(user)){
                return new ResponseData("该医院账号不存在");
            }
            if(!(user.getPassword().equals(md5Pwd))){
                return new ResponseData("密码不正确");
            }
        }else{
            return new ResponseData("号码格式不正确");
        }
        return new ResponseData(user);
    }

    //@Override
    //public User (User user) {
    //    if(user.getId()!=null){
    //        tUserMapper.insert(user);
    //    }
    //    return null;
    //}


    @Override
    public User selectHPO(Integer id) {
        return tUserMapper.selectHPO(id);
    }

    @Override
    public IPage<User> selectHP(IPage<User>page, String searchKey, Integer dealerId) {
        return tUserMapper.selectHP(page,searchKey,dealerId);
    }

    @Override
    public List<User> selectUIN(Integer id) {
        return tUserMapper.selectUIN(id);
    }

    @Override
    public IPage<User> selectPage(IPage<User> page, Wrapper<User> wrapper) {
        return tUserMapper.selectPage(page,wrapper);
    }

    //@Override
    //public List<Map> matchDealer(Integer id) {
    //    return tUserMapper.matchDealer(id);
    //}

    @Override
    public int insert(User user) {
        String md5Password= MD5Util.string2MD5(user.getPassword());
        user.setPassword(md5Password);
            return tUserMapper.insert(user);
    }

    @Override
    public User selectById(Integer id) {
        return tUserMapper.selectById(id);
    }

    @Override
    public User selectOne(Wrapper queryWrapper) {
        return tUserMapper.selectOne(null);
    }

    @Override
    public List<User> selectList(Wrapper wrapper) {
        return tUserMapper.selectList(wrapper);
    }

    @Override
    public int deleteById(Integer id) {
        return tUserMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tUserMapper.delete(null);
    }

    @Override
    public int updateById(User user) {
        return tUserMapper.updateById(user);
    }

    @Override
    public int update(User user, Wrapper wrapper) {
        return tUserMapper.update(user,null);
    }
}
