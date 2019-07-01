package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.device_manager.entity.Device;

import java.util.List;


public interface DeviceService {
    Response insert(Device device);
    Device selectById(Integer id);
    Device selectOne(Wrapper queryWrapper);
    List<Device> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(Device device);
    Response update(Integer[] ids, Device device);
    IPage<Device> selectPage(IPage<Device> page, Wrapper<Device> wrapper);
    //List<Map<String,String>> selectHNL(Integer id);
    //List<Map<String,String>> selectPN(Integer id);
    //List<Map<String,String>> selectDT(Integer id);

    Device getRecords(Integer id);
    IPage<Device> selectDevice(IPage<Device> page, Integer deviceTypeId, String searchKey);
    Device getOne(Integer id);
    IPage<Device> selectDeviceByDealer(IPage<Device> page, Device device, String searchKey);
    IPage<Device> selectDeviceByUser(IPage<Device> page, Device device, String searchKey);
   // Integer selectDeviceCount(Integer id);
    //IPage<Device>selectNPD(IPage<Device> page,Integer deviceTypeId, String searchKey);
    //tring selectCN(Integer id);
    //根据多个id查询对应的经销商
    //List<Map<String,String>> selectBatchDealer(Integer[] ids);
}
