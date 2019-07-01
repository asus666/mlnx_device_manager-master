package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.device_manager.entity.Producer;

import java.util.List;

public interface ProducerService {
    int insert(Producer producer);
    Producer selectById(Integer id);
    Producer selectOne(Wrapper queryWrapper);
    //List<Producer> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(Producer producer);
    int update(Producer producer, Wrapper wrapper);
    //IPage selectPage(String searchKey,IPage<Producer>page,Wrapper<Producer>wrapper);
    List<Producer> selectPIN();
    IPage<Producer> selectProducer(IPage<Producer> page, String searchKey);
}
