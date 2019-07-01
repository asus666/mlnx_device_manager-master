package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.ProducerService;
import com.mlnx.device_manager.entity.Producer;
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
@RequestMapping(value = "/producer")
public class ProducerController extends BaseController {
    @Autowired
    private ProducerService producerServiceIml;

    @ApiOperation(value="获取出厂信息列表只有id name",notes="")
    @GetMapping("/list")
    public Response list(){
        List<Producer> device= producerServiceIml.selectPIN();
        return new ResponseData(device);
    }


    @ApiOperation(value = "出厂商根据输入出厂单位 联系人 联系电话 内容分页数据",notes="")
    @GetMapping("/getPageList")
    public Response page(DeviceForm form){
        IPage<Producer> pageList=producerServiceIml.selectProducer(new Page<Producer>(form.getCurrent(),form.getSize()),form.getSearchKey());
        return new ResponseData(pageList);
    }

    @ApiOperation(value = "获取单个出厂信息",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        Producer device=producerServiceIml.selectById(id);
        return new ResponseData(device);
    }

    @ApiOperation(value = "新增出厂信息")
    @GetMapping(value = "/add")
    public Response add(Producer producer){
        producerServiceIml.insert(producer);
        return new ResponseData("添加成功");
    }

    @ApiOperation(value = "编辑出厂信息")
    @GetMapping(value = "/edit")
    public Response edit(Producer producer){
        producerServiceIml.updateById(producer);
        return new ResponseData("信息修改成功");
    }

    @ApiOperation(value = "删除出厂信息")
    @GetMapping(value = "/remove")
    public Response remove(Integer id){
        producerServiceIml.deleteById(id);
        return new ResponseData("删除成功");
    }
}
