package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.device_manager.entity.Dealer;

import java.util.List;

public interface DealerService {
    int insert(Dealer dealer);
    Dealer selectById(Integer id);
    Dealer selectOne(Wrapper queryWrapper);
    List<Dealer> selectList(Wrapper wrapper, String password);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(Dealer dealer);
    int update(Dealer dealer, Wrapper wrapper);
    IPage selectPage(IPage<Dealer> page, Wrapper<Dealer> wrapper);


    List<Dealer> selectDIN();
    IPage<Dealer> selectDR(IPage<Dealer> page, String searchKey);
    Dealer selectDRO(Integer id);

    Response login(String name, String password);
}
