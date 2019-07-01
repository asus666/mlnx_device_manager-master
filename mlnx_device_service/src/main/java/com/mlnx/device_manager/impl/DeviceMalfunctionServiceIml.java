package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.DeviceMalfunctionService;
import com.mlnx.device_manager.entity.DeviceMalfunction;
import com.mlnx.device_manager.entity.LifeCycle;
import com.mlnx.device_manager.enums.MalfunctionType;
import com.mlnx.device_manager.enums.StateType;
import com.mlnx.device_manager.mappers.TDeviceMalfunctionMapper;
import com.mlnx.device_manager.mappers.TLifeCycleMapper;
import com.mlnx.device_manager.pojo.vo.form.DeviceForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceMalfunctionServiceIml implements DeviceMalfunctionService {
    @Autowired
    private TDeviceMalfunctionMapper tDeviceMalfunctionMapper;

    @Autowired
    private TLifeCycleMapper tLifeCycleMapper;
    @Override
    public DeviceMalfunction getOne(Integer id) {
        return tDeviceMalfunctionMapper.getOne(id);
    }

    //@Override
    //public List<Map<Integer, String>> selectIM() {
        //return tDeviceMalfunctionMapper.selectIM();
    //}

    @Override
    public IPage<DeviceMalfunction> selectNDP(IPage<DeviceMalfunction>page, String searchKey) {
        return tDeviceMalfunctionMapper.selectNDP(page,searchKey);
    }

    @Override
    public IPage<DeviceMalfunction> selectPage(IPage<DeviceMalfunction> page, Wrapper<DeviceMalfunction> wrapper) {
        return tDeviceMalfunctionMapper.selectPage(page,null);
    }

    @Override
    public List<DeviceMalfunction> selectDMF() {
        return tDeviceMalfunctionMapper.selectDMF();
    }

    @Override
    public Response insert(Integer[]deviceIds, DeviceForm form,DeviceMalfunction dmf) {
        //List<DeviceMalfunction> list=new ArrayList<DeviceMalfunction>();
        //能用接口
        //功能: 根据设备 deviceIds
        // 去查找是否存在相应的故障,
        // 没有的将会添加;
        // 不能选择无，选无将报相应错误

        // 有故障,只能在原来的基础上修改
        // 此时点击确认传进去0默认为不变 原来是什么现在还是什么
        Integer[]arr=new Integer[deviceIds.length-1];
        DeviceMalfunction deviceMalfunction=new DeviceMalfunction();
        LifeCycle lifeCycle=new LifeCycle();
        Integer malId=form.getMalId();
        Integer stateId=form.getStateId();

        for(int i=0;i<deviceIds.length-1;i++) {
            arr[i]=deviceIds[i];
            deviceMalfunction.setDeviceId(arr[i]);

            lifeCycle.setDeviceId(arr[i]);
            lifeCycle.setEndPoint(dmf.getBackDate());
            //如果对应的设备id有多条故障记录，则取最近添加的一条,且不为null

            if(malId!=0){
                String mal= MalfunctionType.getTypeByNum(malId);
                deviceMalfunction.setMalfunction(mal);
                lifeCycle.setEvent(mal);
            }else if(tDeviceMalfunctionMapper.selectOne(new QueryWrapper<DeviceMalfunction>().eq("device_id",arr[i]).orderByDesc("id").last("limit 1"))==null){
                //当malId=0时，原来是什么现在还是什么
                //原来是null,设置成null;原来有的，设置成原来的
                    deviceMalfunction.setMalfunction("------测试------");
                    lifeCycle.setEvent("测试");
                }else{
                    String malFun=tDeviceMalfunctionMapper.selectOne(new QueryWrapper<DeviceMalfunction>().eq("device_id",arr[i]).orderByDesc("id").last("limit 1")).getMalfunction();
                    deviceMalfunction.setMalfunction(malFun);
                    lifeCycle.setEvent(malFun);
                }
            //if(remark==null){
            //    deviceMalfunctionServiceIml.
            //}
            if(stateId!=0){
                String st= StateType.getTypeByNum(stateId);
                deviceMalfunction.setState(st);
                lifeCycle.setRemark(st);
            }else{
                deviceMalfunction.setState("------无------");
                lifeCycle.setRemark("无");
            }
            deviceMalfunction.setBackDate(dmf.getBackDate());
            deviceMalfunction.setRemark(dmf.getRemark());
            tDeviceMalfunctionMapper.insert(deviceMalfunction);
            tLifeCycleMapper.insert(lifeCycle);
        }
        return new ResponseData("故障处理成功");
    }

    @Override
    public DeviceMalfunction selectById(Integer id) {
        return tDeviceMalfunctionMapper.selectById(id);
    }

    @Override
    public DeviceMalfunction selectOne(Wrapper queryWrapper) {
        return tDeviceMalfunctionMapper.selectOne(queryWrapper);
    }

    @Override
    public List<DeviceMalfunction> selectList(Wrapper wrapper) {
        return tDeviceMalfunctionMapper.selectList(wrapper);
    }

    @Override
    public Response deleteById(Integer id) {
        DeviceMalfunction producer=tDeviceMalfunctionMapper.selectById(id);
        LifeCycle lifeCycle=new LifeCycle();
        lifeCycle.setDeviceId(producer.getDeviceId());
        //记录故障删除日期
        lifeCycle.setEndPoint(new Date());
        if(producer.getMalfunction()==null){
            lifeCycle.setEvent("删除故障空记录");
        }else{
            lifeCycle.setEvent(producer.getMalfunction());
        }
        lifeCycle.setRemark("已删除");
        tLifeCycleMapper.insert(lifeCycle);
        tDeviceMalfunctionMapper.deleteById(id);
        return new ResponseData("删除成功");
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tDeviceMalfunctionMapper.delete(null);
    }

    @Override
    public int updateById(DeviceMalfunction deviceMalfunction) { return tDeviceMalfunctionMapper.updateById(deviceMalfunction);
    }

    @Override
    public int update(DeviceMalfunction deviceMalfunction, Wrapper wrapper) {
        return tDeviceMalfunctionMapper.update(deviceMalfunction,wrapper);
    }

    @Override
    public List<DeviceMalfunction> getMalRecords(Integer deviceId) {
        return tDeviceMalfunctionMapper.getMalRecords(deviceId);
    }


}
