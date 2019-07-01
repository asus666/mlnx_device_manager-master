package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.device_manager.entity.DeviceMalfunction;
import com.mlnx.device_manager.pojo.vo.form.DeviceForm;

import java.util.List;

public interface DeviceMalfunctionService {
    Response insert(Integer[] deviceIds, DeviceForm form, DeviceMalfunction dmf);
    DeviceMalfunction selectById(Integer id);
    DeviceMalfunction selectOne(Wrapper queryWrapper);
    List<DeviceMalfunction> selectList(Wrapper wrapper);
    Response deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(DeviceMalfunction deviceMalfunction);
    int update(DeviceMalfunction deviceMalfunction, Wrapper wrapper);
    List<DeviceMalfunction> selectDMF();
    IPage<DeviceMalfunction> selectPage(IPage<DeviceMalfunction> page, Wrapper<DeviceMalfunction> wrapper);
    IPage<DeviceMalfunction>selectNDP(IPage<DeviceMalfunction> page, String searchKey);
    //List<Map<Integer,String>> selectIM();
    DeviceMalfunction getOne(Integer id);
    List<DeviceMalfunction> getMalRecords(Integer deviceId);
}
