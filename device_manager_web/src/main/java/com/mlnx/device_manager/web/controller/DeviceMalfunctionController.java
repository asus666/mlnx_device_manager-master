package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.DeviceMalfunctionService;
import com.mlnx.device_manager.entity.DeviceMalfunction;
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
@RequestMapping("/malfunction")
public class DeviceMalfunctionController extends BaseController {

    @Autowired
    private DeviceMalfunctionService deviceMalfunctionServiceIml;

    //@ApiOperation(value="获得故障原因 id name",notes="")
    //@GetMapping("/list")
    //public Response getList(){
    //    List<Map<Integer,String>> device= deviceMalfunctionServiceIml.selectIM();
    //    return new ResponseData(device);
    //}

    @ApiOperation(value="根据输入设备编号 出厂商 经销商内容搜索 模糊查询",notes="")
    @GetMapping("/getPageList")
    public Response selectNDP(DeviceForm form){
        IPage<DeviceMalfunction>device= deviceMalfunctionServiceIml.selectNDP(new Page<DeviceMalfunction>(form.getCurrent(),form.getSize()),form.getSearchKey());
        return new ResponseData(device);
    }


    //@ApiOperation(value="获得故障信息分页数据",notes="")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "current", value = "当前页序号", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "Integer"),
    //})
    //@GetMapping("/getPageList")
    //public Response list(Integer current,Integer size){
    //    IPage<DeviceMalfunction> device= deviceMalfunctionServiceIml.selectPage(new Page<DeviceMalfunction>(current,size),null);
    //    return new ResponseData(device);
    //}

    @ApiOperation(value="获得故障列表 包括对应的设备",notes="")
    @GetMapping("/getList")
    public Response list(){
        List<DeviceMalfunction> device= deviceMalfunctionServiceIml.selectDMF();
        return new ResponseData(device);
    }

    @ApiOperation(value = "获取单条故障",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        DeviceMalfunction device=deviceMalfunctionServiceIml.getOne(id);
        return new ResponseData(device);
    }

    @ApiOperation(value ="处理故障信息",notes="")
    @GetMapping("/add")
    public Response add(Integer[]deviceIds, DeviceForm form, DeviceMalfunction dmf){
        return deviceMalfunctionServiceIml.insert(deviceIds,form,dmf);
    }

    //@ApiOperation(value ="故障编辑",notes="")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "id", value = "故障数据库id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "deviceId", value = "设备id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "malfunction", value = "故障原因", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "backDate", value = "返厂时间", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "remark", value = "备注", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "state", value = "0：未解决；1，已解决", required = true, dataType = "String")
    //})
    //@GetMapping("/edit")
    //    public Response edit(DeviceMalfunction deviceMalfunction,Integer state){
    //
    //        deviceMalfunction.setState(state);
    //        deviceMalfunctionServiceIml.updateById(deviceMalfunction);
    //        return new ResponseData(deviceMalfunction);
    //    }

    //@ApiOperation(value ="故障编辑",notes="")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "deviceIds", value = "多个设备id", required = true, dataType = "数组比如：ids=1，2，3"),
    //        @ApiImplicitParam(name = "malId", value = "故障id", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "backDate", value = "返厂时间", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "remark", value = "备注", required = true, dataType = "String"),
    //        @ApiImplicitParam(name = "stateId", value = "0：未解决；1，已解决", required = true, dataType = "String")
    //})
    //@GetMapping("/edit")
    //public Response batchEdit(Integer[]deviceIds,Integer malId,Date backDate,String remark,Integer stateId){
    //    //DeviceMalfunction producer=new DeviceMalfunction();
    //    //producer.setDeviceId(deviceId);
    //    //List<DeviceMalfunction> list=new ArrayList<DeviceMalfunction>();
    //    Integer []arr=new Integer[deviceIds.length-1];
    //    for(int i=0;i<deviceIds.length-1;i++){
    //        arr[i]=deviceIds[i];
    //        List<DeviceMalfunction> deviceMalfunction=deviceMalfunctionServiceIml.selectList(new QueryWrapper<DeviceMalfunction>().eq("device_id",arr[i]));
    //        Iterator<DeviceMalfunction> it=deviceMalfunction.iterator();
    //        while(it.hasNext()){
    //            DeviceMalfunction d=it.next();
    //            if(malId==0){
    //                d.setMalfunction(deviceMalfunctionServiceIml.selectOne(new QueryWrapper<DeviceMalfunction>().eq("device_id",arr[i]).orderByDesc("id").last("limit 1")).getMalfunction());
    //            }else{
    //                d.setMalfunction(MalfunctionType.getByNum(malId).toString());
    //            }
    //            d.setBackDate(backDate);
    //            if(remark==null){
    //                d.setRemark(d.getRemark());
    //            }
    //            d.setRemark(remark);
    //            if(stateId==0){
    //                d.setState(deviceMalfunctionServiceIml.selectOne(new QueryWrapper<DeviceMalfunction>().eq("device_id",arr[i]).orderByDesc("id").last("limit 1")).getState());
    //            }else{
    //                d.setState(MalfunctionType.getByNum(stateId).toString());
    //            }
    //            deviceMalfunctionServiceIml.update(d,new UpdateWrapper<DeviceMalfunction>().eq("device_id",d.getDeviceId()));
    //            //list.add(d);
    //        }
    //    }
    //    return new ResponseData("故障处理成功");
    //}

    @ApiOperation(value ="故障删除",notes="")
    @GetMapping("/remove")
    public Response remove(Integer id){
       return deviceMalfunctionServiceIml.deleteById(id);
    }

    @ApiOperation(value ="故障记录",notes="")
    @GetMapping("/getRecords")
    public Response getMal(Integer deviceId){
        List<DeviceMalfunction> producer=deviceMalfunctionServiceIml.getMalRecords(deviceId);
        return new ResponseData(producer);
    }



    @ApiOperation(value ="得到故障类型列表",notes="")
    @GetMapping("/list")
    public Response getTranList() {
        List<Map> map = new ArrayList<>();
        //放到map中要求是中文
        Map map1=new HashMap();
        Map map2=new HashMap();
        Map map3=new HashMap();
        Map map4=new HashMap();
        Map map5=new HashMap();
        Map map6=new HashMap();
        Map map7=new HashMap();
        map1.put("id",1);
        map1.put("name","外观故障");
        map2.put("id",2);
        map2.put("name","储存故障");
        map3.put("id",3);
        map3.put("name","导联故障");
        map4.put("id",4);
        map4.put("name","信号故障");
        map5.put("id",5);
        map5.put("name","软件故障");
        map6.put("id",6);
        map6.put("name","配件故障");
        map7.put("id",7);
        map7.put("name","其他");
        map.add(0,map1);
        map.add(1,map2);
        map.add(2,map3);
        map.add(3,map4);
        map.add(4,map5);
        map.add(5,map6);
        map.add(6,map7);
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


}