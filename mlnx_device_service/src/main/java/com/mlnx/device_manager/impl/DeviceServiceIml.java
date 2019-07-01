package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.DeviceService;
import com.mlnx.device_manager.entity.*;
import com.mlnx.device_manager.enums.TransmissionType;
import com.mlnx.device_manager.mappers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceIml implements DeviceService {
    @Autowired
    private TDeviceMapper tDeviceMapper;
    @Autowired
    private TDealerMapper tDealerMapper;
    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TContractMapper tContractMapper;
    @Autowired
    private TLifeCycleMapper tLifeCycleMapper;





    //@Override
    //public Integer selectDeviceCount(Integer id) {
    //    return tDeviceMapper.selectDeviceCount(id);
    //}


    @Override
    public Device getOne(Integer id) {
        return tDeviceMapper.getOne(id);
    }

    @Override
    public IPage<Device> selectDeviceByDealer(IPage<Device>page,Device device, String searchKey) {
        return tDeviceMapper.selectDeviceByDealer(page,device.getDeviceTypeId(),device.getDealerId(),searchKey);
    }

    @Override
    public IPage<Device> selectDeviceByUser(IPage<Device>page, Device device, String searchKey) {
        return tDeviceMapper.selectDeviceByUser(page,device.getDeviceTypeId(),device.getHospitalId(),searchKey);
    }

    @Override
    public IPage<Device> selectPage(IPage<Device> page, Wrapper<Device> wrapper) {
        return tDeviceMapper.selectPage(page,wrapper);
    }

    @Override
    public IPage<Device> selectDevice(IPage<Device> page, Integer deviceTypeId, String searchKey) {
        return tDeviceMapper.selectDevice(page,deviceTypeId,searchKey);
    }

    //@Override
    //public List<Map<String,String>> selectHNL(Integer id) {
    //    return tDeviceMapper.selectHNL(id);
    //}

    //@Override
    //public String selectCN(Integer id) {
    //    return tDeviceMapper.selectCN(id);
    //}

    //@Override
    //public List<Map<String,String>> selectPN(Integer id) {
    //    return tDeviceMapper.selectPN(id);
    //}
    //
    //@Override
    //public List<Map<String, String>> selectDT(Integer id) {
    //    return tDeviceMapper.selectDT(id);
    //}

    @Override
    public Response insert(Device device) {
        //从各张表中查出id 对应的名字再设置进device中，完成对设备的新增处理
        //怎么查？
        //Contract contract=tContractMapper.selectById(device.getId());
        //根据经销商id查询出医院id
        //Integer id=device.getDealerId();
        //tUserMapper.selectList(new QueryWrapper<User>().eq("dealer_id",id));
        device.setTransmissionType(TransmissionType.getByNum(Integer.parseInt(device.getTransmissionType())).toString());
        Integer dealerId=device.getDealerId();
        Integer hospitalId=device.getHospitalId();
        if(dealerId==-1&&hospitalId==-1){
            device.setDealerId(null);
            device.setHospitalId(null);
            tDeviceMapper.insert(device);
        }else{
            if(hospitalId==-1){
                device.setDealerId(dealerId);
                device.setHospitalId(null);
                tDeviceMapper.insert(device);
            }else{
                device.setDealerId(dealerId);
                device.setHospitalId(hospitalId);
                tDeviceMapper.insert(device);
            }
        }
        LifeCycle lifeCycle=new LifeCycle();
        lifeCycle.setDeviceId(device.getId());
        lifeCycle.setEndPoint(device.getProductionTime());
        lifeCycle.setEvent("出厂");
        lifeCycle.setRemark("无");
        tLifeCycleMapper.insert(lifeCycle);
        return new ResponseData("设备添加成功");
    }

    @Override
    public Device selectById(Integer id) {
        return tDeviceMapper.selectById(id);
    }

    @Override
    public Device selectOne(Wrapper queryWrapper) {
        return tDeviceMapper.selectOne(null);
    }

    @Override
    public List<Device> selectList(Wrapper wrapper) {
        return tDeviceMapper.selectList(wrapper);
    }

    @Override
    public int deleteById(Integer id) {
        return tDeviceMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tDeviceMapper.delete(null);
    }

    @Override
    public int updateById(Device device) {
        return tDeviceMapper.updateById(device);
    }

    @Override
    public Response update(Integer []ids,Device de) {
        //List<Device>list=new ArrayList<>();
        Integer[] arr = new Integer[ids.length - 1];
        for (int i = 0; i < ids.length - 1; i++) {
            arr[i] = ids[i];
        }
        Integer dealerId=de.getDealerId();
        Integer hospitalId=de.getHospitalId();
        Integer contractId=de.getContractId();
        LifeCycle lifeCycle=new LifeCycle();
        for (Integer id : arr) {
            Device device = tDeviceMapper.selectById(id);
            // deviceService.update(device, new UpdateWrapper<Device>().eq("id", id));
            if(dealerId==-1){
                device.setDealerId(null);
            }
            if(hospitalId==-1){
                device.setHospitalId(null);
            }
            if(contractId==-1){
                device.setContractId(null);
            }

            //定一个需求：设备出厂后，必须得有经销商(不为空)，设备新增时出厂商和经销商不为空
            //修改时可以修改为另一个经销商,此时医院与合同，跟着变成新的
            //也可以不变,变个新的医院,合同跟着变
            if (dealerId== 0 && hospitalId== 0 && contractId == 0) {
                tDeviceMapper.update(device, new UpdateWrapper<Device>().eq("id", id));
            } else if(dealerId!=0&&dealerId!=device.getDealerId()){

                if(hospitalId==0){
                    return new ResponseData("请选择一家新医院");
                }

                if(contractId==0||contractId==device.getContractId()){
                    return new ResponseData("请选择一个新合同");
                }


                //记录更新时间
                lifeCycle.setEndPoint(new Date());
                lifeCycle.setDeviceId(id);
                lifeCycle.setEvent("更新");
                if(device.getContractId()!=null){
                    lifeCycle.setRemark("经销商由: "+tDealerMapper.selectOne(new QueryWrapper<Dealer>().
                            select("dealer_name").eq("id",device.getDealerId())).getDealerName()+
                            ",修改为: "+tDealerMapper.selectOne(new QueryWrapper<Dealer>().select("dealer_name").
                            eq("id",dealerId)).getDealerName()+";医院由: "+tUserMapper.selectOne(new QueryWrapper<User>().select("hospital_name").
                            eq("id",device.getHospitalId())).getHospitalName()+",修改为: "+
                            tUserMapper.selectOne(new QueryWrapper<User>().select("hospital_name").eq("id",hospitalId)).getHospitalName()+";合同编号由: "+
                            tContractMapper.selectOne(new QueryWrapper<Contract>().select("numeration").eq("id",device.getContractId())).getNumeration()+",修改为: "+
                            tContractMapper.selectOne(new QueryWrapper<Contract>().select("numeration").eq("id",contractId)).getNumeration());
                }else{
                    lifeCycle.setRemark("经销商由: "+tDealerMapper.selectOne(new QueryWrapper<Dealer>().
                            select("dealer_name").eq("id",device.getDealerId())).getDealerName()+
                            ",修改为: "+tDealerMapper.selectOne(new QueryWrapper<Dealer>().select("dealer_name").
                            eq("id",dealerId)).getDealerName()+";医院由: "+tUserMapper.selectOne(new QueryWrapper<User>().select("hospital_name").
                            eq("id",device.getHospitalId())).getHospitalName()+",修改为: "+
                            tUserMapper.selectOne(new QueryWrapper<User>().select("hospital_name").eq("id",hospitalId)).getHospitalName()+";新增合同编号:"+
                            tContractMapper.selectOne(new QueryWrapper<Contract>().select("numeration").eq("id",contractId)).getNumeration());
                }
                tLifeCycleMapper.insert(lifeCycle);
                device.setDealerId(dealerId);
                device.setHospitalId(hospitalId);
                device.setContractId(contractId);
                tDeviceMapper.update(device, new UpdateWrapper<Device>().eq("id", id));

            }else if(hospitalId!=0&&hospitalId!=device.getHospitalId()){
                lifeCycle.setEndPoint(new Date());
                lifeCycle.setDeviceId(id);
                lifeCycle.setEvent("更新");
                lifeCycle.setRemark("医院由: "+tUserMapper.selectOne(new QueryWrapper<User>().select("hospital_name").
                        eq("id",device.getHospitalId())).getHospitalName()+",修改为: "+
                        tUserMapper.selectOne(new QueryWrapper<User>().select("hospital_name").eq("id",hospitalId)).getHospitalName());
                tLifeCycleMapper.insert(lifeCycle);
                device.setHospitalId(hospitalId);
                if(contractId==0||contractId==device.getContractId()){
                    tDeviceMapper.update(device, new UpdateWrapper<Device>().eq("id", id));

                }else{
                    return new ResponseData("请勿变更合同");
                }
            }else{
                if(contractId!=0&&contractId!=device.getContractId()){
                    return new ResponseData("请勿变更合同");
                }else{
                    tDeviceMapper.update(device, new UpdateWrapper<Device>().eq("id", id));
                }
            }
        }
        return new ResponseData("批量处理成功");
    }

    //@Override
    //public List<Map<String, String>> selectBatchDealer(Integer[] ids) {
    //    return tDeviceMapper.selectBatchDealer(ids);
    //}

    @Override
    public Device getRecords(Integer deviceId) {
        return tDeviceMapper.selectOne(new QueryWrapper<Device>().select("production_time","numeration").eq("id",deviceId));
    }
}
