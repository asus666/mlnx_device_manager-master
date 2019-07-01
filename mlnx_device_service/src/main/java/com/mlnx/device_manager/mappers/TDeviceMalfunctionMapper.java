package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.DeviceMalfunction;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TDeviceMalfunctionMapper extends BaseMapper<DeviceMalfunction> {
    //显示
    @Select("select a.id,b.numeration,a.malfunction,a.back_date,a.state,a.remark from t_device_malfunction a LEFT JOIN t_device b on a.device_id=b.id")
    List<DeviceMalfunction> selectDMF();

    //搜索
    Page<DeviceMalfunction>selectNDP(IPage<DeviceMalfunction> page, @Param("searchKey") String searchKey);

    //id name
   // List<Map<Integer,String>> selectIM();

    //得到一条
    //@Select("select a.id,b.numeration,a.malfunction,a.back_date,a.state,a.remark from t_device_malfunction a LEFT JOIN t_device b on a.device_id=b.id where a.id=#{id}")
    DeviceMalfunction getOne(Integer id);

    @Select("select a.back_date,a.malfunction,(case a.state when 'RETURNED' then '已返厂'when 'FIXED' then '维修中'when 'DONE' then '已解决'when 'UNDONE' then '未解决'else '空的' end)state,a.remark\n" +
            "        from t_device_malfunction a LEFT JOIN t_device b on a.device_id=b.id\n" +
            "        where b.id=#{deviceId}")
    List<DeviceMalfunction> getMalRecords(Integer deviceId);

    //@Select("select a.back_date,a.malfunction from t_device_malfunction a left join t_device b on a.device_id=b.id where b.id=#{deviceId}")

}
