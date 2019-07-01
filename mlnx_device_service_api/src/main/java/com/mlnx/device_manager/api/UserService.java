package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.device_manager.entity.User;

import java.util.List;

/**
 * Created by amanda.shan on 2019/1/30.
 */
public interface UserService {

    Response login(String name, String password);
    int insert(User user);
    User selectById(Integer id);
    User selectOne(Wrapper queryWrapper);
    List<User> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(User user);
    int update(User user, Wrapper wrapper);
    //List<Map> matchDealer(Integer id);
    IPage<User> selectPage(IPage<User> page, Wrapper<User> wrapper);
    List<User> selectUIN(Integer id);
    IPage<User> selectHP(IPage<User> page, String searchKey, Integer dealerId);
    User selectHPO(Integer id);
}
