package com.mlnx.device_manager.web.controller;

import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.DeviceTypeService;
import com.mlnx.device_manager.entity.DeviceType;
import io.swagger.annotations.ApiOperation;
import org.shan.spring.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deviceType")
public class DeviceTypeController extends BaseController {

    @Autowired
    private DeviceTypeService deviceTypeServiceIml;

    @ApiOperation(value="获得所有设备类型 中文显示",notes="")
    @GetMapping("/list")
    public Response list(){
        List<DeviceType> device=deviceTypeServiceIml.selectDTC();
        return new ResponseData(device);
    }


    //@ApiOperation(value="获得所有设备类型",notes="")
    //@GetMapping("/list")
    //public Response list(){
    //    List<DeviceType> device=deviceTypeServiceIml.selectList(null);
    //    return new ResponseData(device);
    //}

    @ApiOperation(value = "获取单个设备类型",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        DeviceType device=deviceTypeServiceIml.selectById(id);
        return new ResponseData(device);
    }

    //@ApiOperation(value ="新增设备类型",notes="")
    //@ApiImplicitParam(name = "name",value = "设备类型名称",required = true,dataType = "String")
    //@GetMapping("/add")
    //public Response add(String name){
      //  DeviceType producer=new DeviceType();
        //producer.setName(name);
        //deviceTypeServiceIml.insert(producer);
        //return new ResponseData(producer);
    //}

    //@ApiOperation(value ="设备类型编辑",notes="")
    //@ApiImplicitParam(name = "name", value = "设备类型名称", required = true, dataType = "String")
    //@GetMapping("/edit")
    //public Response edit(String name){
      //  DeviceType producer=new DeviceType();
      //  producer.setName(name);
      //  deviceTypeServiceIml.updateById(producer);
      //  return new ResponseData(producer);
   // }

    //@ApiOperation(value ="设备类型删除",notes="")
    //@ApiImplicitParam(name = "id",value = "设备类型序号",required = true,dataType = "Integer")
    //@GetMapping("/remove")
    //public Response remove(Integer id){
       // DeviceType producer=deviceTypeServiceIml.selectById(id);
        //deviceTypeServiceIml.deleteById(id);
        //return new ResponseData(producer);
    //}
}
