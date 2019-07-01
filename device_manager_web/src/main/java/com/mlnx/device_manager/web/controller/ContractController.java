package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.ContractService;
import com.mlnx.device_manager.entity.Contract;
import com.mlnx.device_manager.pojo.vo.form.DeviceForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.shan.spring.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/contract")
public class ContractController extends BaseController {
    @Autowired
    private ContractService contractService;

    @ApiOperation(value = "根据合同id 显示设备编号",notes = "")
     @GetMapping("/show")
    public Response show(Integer id){
        return contractService.selectDN(id);
    }

    //@GetMapping("/shuo")
    //public Response shuo(Integer id){
    //
    //
    //    List<Map<String,String>> device=contractService.selectID(id);
    //
    //
    //    return new ResponseData(device);
    //}

    @ApiOperation(value="根据输入合同编号 经手人内容搜索合同信息 模糊查询",notes="")
    @GetMapping("/getPageList")
    public Response selectNDP(DeviceForm form){
        return contractService.selectCNS(new Page<Contract>(form.getCurrent(),form.getSize()),form.getSearchKey());
    }

    //@ApiOperation(value="获得合同信息医院 经销商都在内 分页",notes="")
    //@GetMapping("/getPageList")
    //public Response list(Integer current,Integer size){
    //    List<Map<String,String>> device= contractService.selectContract(current,size);
    //    return new ResponseData(device);
    //}

    @ApiOperation(value="获得合同信息只有id 合同编号",notes="")
    @GetMapping("/list")
    public Response list(){
        List<Contract> device= contractService.selectCIN();
        return new ResponseData(device);
    }

    @ApiOperation(value = "获取单个合同",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        Contract device=contractService.getOne(id);
        return new ResponseData(device);
    }

    @ApiOperation(value = "新增合同")
    @GetMapping("/add")
    public Response add(Contract contract){
        //新增合同的同时增加相应生命周期
        //此时需要设备id吗？最好不需要 实际上需要，所以需要通过合同找出
        //设备id,此时会有很多，因此每个设备一条记录
        //增加设备时插入还是增加合同时？
        contractService.insert(contract);
        return new ResponseData("合同添加成功");
    }

    @ApiOperation(value = "编辑合同")
    @GetMapping("/edit")
    public Response edit(Contract contract){
        contractService.updateById(contract);
        return new ResponseData("合同修改成功");
    }

    @ApiOperation(value = "删除合同")
    @GetMapping("/remove")
    public Response remove(Integer id){
        contractService.deleteById(id);
        return new ResponseData("删除成功");
    }

    //@GetMapping("/count")
    //public Response count(Integer id){
    //    Integer count=contractService.selectDNC(id);
    //    return new ResponseData(count);
    //}

    //@GetMapping("/getList")
    //public Response getList(){
    //    List<Contract>count=contractService.selectList(null);
    //    return new ResponseData(count);
    //}
    @ApiOperation(value = "根据设备id得到合同签订记录")
    @GetMapping("/getRecords")
    public Response getDeliverDate(Integer deviceId){
        List<Contract> contract=contractService.getRecords(deviceId);
        return new ResponseData(contract);
    }

}
