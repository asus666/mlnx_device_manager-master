package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.device_manager.api.ProducerService;
import com.mlnx.device_manager.entity.Producer;
import com.mlnx.device_manager.mappers.TProducerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public  class ProducerServiceIml implements ProducerService {
    @Autowired
    private TProducerMapper tProducerMapper;


    //@Override
    //public List<Producer> selectList(Wrapper wrapper) {
    //    return tProducerMapper.selectList(wrapper);
    //}


    @Override
    public IPage<Producer> selectProducer(IPage<Producer> page, String searchKey) {
        return tProducerMapper.selectProducer(page,searchKey);
    }

    @Override
    public List<Producer> selectPIN() {
        return tProducerMapper.selectList(new QueryWrapper<Producer>().select("id","name"));
    }

    //@Override
    //public IPage selectPage(String searchKey,IPage<Producer> page, Wrapper<Producer> wrapper) {
    //    return tProducerMapper.selectPage(page,new QueryWrapper<Producer>().like("name",searchKey).or().like("linkman",searchKey).or().like("phone",searchKey));
    //}

    @Override
    public int insert(Producer producer) {
        return tProducerMapper.insert(producer);
    }

    @Override
    public Producer selectById(Integer id) {
        return tProducerMapper.selectById(id);
    }

    @Override
    public Producer selectOne(Wrapper queryWrapper) {
        return tProducerMapper.selectOne(null);
    }

    //@Override
    //public List<Producer> selectList(Wrapper wrapper) {
    //    return tProducerMapper.selectList(null);
    //}

    @Override
    public int deleteById(Integer id) {
        return tProducerMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tProducerMapper.delete(null);
    }

    @Override
    public int updateById(Producer producer) {
        return tProducerMapper.updateById(producer);
    }

    @Override
    public int update(Producer producer, Wrapper wrapper) {
        return tProducerMapper.update(producer,null);
    }


}
