package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.DeviceService;
import com.mlnx.device_manager.entity.Device;
import com.mlnx.device_manager.pojo.vo.form.DeviceForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.shan.spring.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/device")
public class DeviceController extends BaseController {
    @Autowired
    private DeviceService deviceService;

    //@ApiOperation(value ="根据经销商id得到医院",notes="")
    //@ApiImplicitParam(name = "id",value = "用户选择的经销商序号",required = true,dataType = "Integer")
    //@GetMapping("/getHNL")
    //public Response getHospital(Integer id){
      //  List<Map<String,String>> map=deviceService.selectHN(id);
        //return new ResponseData(map);
    //}

    //@ApiOperation(value ="根据合同id得到合同名称",notes="")
    //@ApiImplicitParam(name = "id",value = "用户选择的合同id",required = true,dataType = "Integer")
    //@GetMapping("/getCN")
    //public Response getCN(Integer id){
    //     String map=deviceService.selectCN(id);
    //    return new ResponseData(map);
    //}

    //@ApiOperation(value = "根据设备类型id  得到数据条数",notes = "")
    //@ApiImplicitParam(name = "deviceTypeId", value = "设备类型", required = true, dataType = "Integer")
    //@GetMapping("/count")
    //public Response selectDeviceCount(Integer deviceTypeId){
    //    Integer map=deviceService.selectDeviceCount(deviceTypeId);
    //    return new ResponseData(map);
    //}

    @ApiOperation(value ="根据经销商id和设备类型id  分页得到设备详细信息",notes="")
    @GetMapping("/dealerList")
    public Response getDeviceByDealerId(Device device, DeviceForm form){
        IPage<Device> map=deviceService.selectDeviceByDealer(new Page<Device>(form.getCurrent(),form.getSize()),device,form.getSearchKey());
        return new ResponseData(map);
    }

    @ApiOperation(value ="根据医院id和设备类型id  分页得到设备详细信息",notes="")
    @GetMapping("/userList")
    public Response getDeviceByHospitalId(Device device, DeviceForm form){
        IPage<Device> map=deviceService.selectDeviceByUser(new Page<Device>(form.getCurrent(),form.getSize()),device,form.getSearchKey());
        return new ResponseData(map);
    }

    @ApiOperation(value ="根据设备类型  分页得到设备详细信息",notes="")
    @GetMapping("/list")
    public Response getHNL(DeviceForm form,Device device){
        IPage<Device> map=deviceService.selectDevice(new Page<Device>(form.getCurrent(),form.getSize()),device.getDeviceTypeId(),form.getSearchKey());
        return new ResponseData(map);
    }


    //@ApiOperation(value ="根据经销商id得到医院名称",notes="")
    //@ApiImplicitParam(name = "id",value = "用户选择的经销商id",required = true,dataType = "Integer")
    //@GetMapping("/getHNL")
    //public Response getHNL(Integer id){
    //    List<Map<String,String>> map=deviceService.selectHNL(id);
    //    return new ResponseData(map);
    //}

    //@ApiOperation(value ="根据出厂商id得到出厂商名称",notes="")
    //@ApiImplicitParam(name = "id",value = "用户选择的出厂商id",required = true,dataType = "Integer")
    //@GetMapping("/getPN")
    //public Response getPN(Integer id){
    //    List<Map<String,String>> map=deviceService.selectPN(id);
    //    return new ResponseData(map);
    //}

    //@ApiOperation(value ="根据设备类型id得到设备类型名称",notes="")
    //@ApiImplicitParam(name = "id",value = "用户选择的设备类型id",required = true,dataType = "Integer")
    //@GetMapping("/getDT")
    //public Response getDT(Integer id){
    //    List<Map<String,String>> map=deviceService.selectDT(id);
    //    return new ResponseData(map);
    //}

    //@ApiOperation(value="根据设备类型获取设备列表",notes="")
    //@GetMapping("/list")
    //public Response list(Integer deviceTypeId){
    //    List<Device> device= deviceService.selectList(new QueryWrapper<Device>().eq("device_type_id",deviceTypeId));
    //    return new ResponseData(device);
    //}

    @ApiOperation(value = "获取单个设备信息",notes = "")
    @GetMapping("/get")
    public Response getOne(Integer id){
        Device device=deviceService.getOne(id);
        return new ResponseData(device);
    }

    //@ApiOperation(value = "设备分页数据",notes="")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "current", value = "当前页序号", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "Integer"),
    //})
    //@GetMapping("/{deviceType}/{current}/{size}")
    //public Response page(@PathVariable("deviceType") Integer deviceType, @PathVariable("current") Integer current, @PathVariable("size") Integer size){
    //    IPage<Device> pageList=null;
    //    if(DeviceType.getTypeByCode(deviceType)=="心电"){
    //        pageList= deviceService.selectPage(new Page<Device>(current,size),new QueryWrapper<Device>().eq("device_type",DeviceType.getByCode(deviceType)));
    //        return new ResponseData(pageList);
    //    }else if(DeviceType.getTypeByCode(deviceType)=="血压"){
    //        pageList= deviceService.selectPage(new Page<Device>(current,size),new QueryWrapper<Device>().eq("device_type",DeviceType.getByCode(deviceType)));
    //        return new ResponseData(pageList);
    //    }else if(deviceType==2){
    //        pageList= deviceService.selectPage(new Page<Device>(current,size),new QueryWrapper<Device>().eq("device_type",DeviceType.getByCode(deviceType)));
    //        return new ResponseData(pageList);
    //    }else{
    //        return null;
    //    }
    //}

    @ApiOperation(value="新增设备",notes="")
    @GetMapping("/add")
    public Response add(Device device){
        return deviceService.insert(device);
    }

    //@ApiOperation(value="编辑设备",notes="")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id", value = "要修改设备id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "numeration", value = "设备编号", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "mcuId", value = "mcuId", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "macAddress", value = "mac地址", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "transmissionType", value = "传蓝牙设备传输 无线设备传输 gprs设备传输", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "producerId", value = "出厂单位id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "dealerId", value = "经销商id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "hospitalId", value = "医院id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "productionTime", value = "出厂时间", required = true, dataType = "Date"),
    //})
    //@GetMapping("/edit")
    //public Response edit(Device device,String transmissionType){
    //    device.setTransmissionType(TransmissionType.valueOf(transmissionType).toString());
    //    deviceService.updateById(device);
    //    return new ResponseData(device);
    //}

    @ApiOperation(value ="设备批量处理",notes="")
    @GetMapping("/batchEdit")
    public Response batchEdit(Integer []ids, Device device) {
        return deviceService.update(ids,device);
    }


    @ApiOperation(value ="设备删除",notes="")
    @GetMapping("/remove")
    public Response remove(Integer id){
        deviceService.deleteById(id);
        return new ResponseData("删除成功");
    }

    //@ApiOperation(value ="根据多个设备id得到多个dealer",notes="")
    //@ApiImplicitParam(name = "ids",value = "多个设备id",required = true,dataType = "Integer")
    //@GetMapping("/batchDealer")
    //public Response getBatchDealer(Integer[] ids){
    //    for(Integer id:ids){
    //        deviceService.selectBatchDealer(ids);
    //    }
    //
    //    return new ResponseData(device);
    //}

    @ApiOperation(value ="得到设备状态列表",notes="")
    @GetMapping("/getState")
    public Response getState(){
        List<Map> map = new ArrayList<>();
        //放到map中要求是中文
        Map map1=new HashMap();
        Map map2=new HashMap();
        Map map3=new HashMap();
        Map map4=new HashMap();
        map1.put("id",1);
        map1.put("name","已返厂");
        map2.put("id",2);
        map2.put("name","维修中");
        map3.put("id",3);
        map3.put("name","已解决");
        map4.put("id",4);
        map4.put("name","未解决");
        map.add(0,map1);
        map.add(1,map2);
        map.add(2,map3);
        map.add(3,map4);
        return new ResponseData(map);
    }


    @ApiOperation(value ="得到传输类型列表",notes="")
    @GetMapping("/getTranList")
    public Response getTranList() {
       List<Map> map = new ArrayList<>();
        //放到map中要求是中文
        Map map1=new HashMap();
        Map map2=new HashMap();
        Map map3=new HashMap();
        map1.put("id",1);
        map1.put("name","蓝牙设备传输");
        map2.put("id",2);
        map2.put("name","无线设备传输");
        map3.put("id",3);
        map3.put("name","GPRS设备传输");
       map.add(0,map1);
       map.add(1,map2);
       map.add(2,map3);
       // for(Map m:map) {
       //     for (TransmissionType t : TransmissionType.values()) {
       //         m.put("id", t.ordinal() + 1);
       //         m.put("name", t.getType());
       //         //map.add(m);
       //     }

            //for (TransmissionType t : TransmissionType.values()) {
            //
            //}
       // }
        return new ResponseData(map);
    }

    @ApiOperation(value ="根据设备id得到出厂记录",notes="")
    @GetMapping("/getRecords")
    public Response getRecords(Integer deviceId){
        Device producer=deviceService.getRecords(deviceId);
        return new ResponseData(producer);
    }




}



