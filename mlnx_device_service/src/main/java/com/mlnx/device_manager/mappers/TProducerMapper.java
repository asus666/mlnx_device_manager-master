package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.Producer;
import org.apache.ibatis.annotations.Param;

public interface TProducerMapper extends BaseMapper<Producer> {
    //@Select("select id,name from t_producer")
    //List<Map<Integer,String>> selectPIN();
    Page<Producer> selectProducer(IPage<Producer> page, @Param("searchKey") String searchKey);
}
