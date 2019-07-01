package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.LifeCycleService;
import com.mlnx.device_manager.entity.LifeCycle;
import com.mlnx.device_manager.pojo.vo.form.DeviceForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.shan.spring.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/life")
public class LifeCycleController extends BaseController {
    @Autowired
    private LifeCycleService lifeCycleService;

    @ApiOperation(value ="根据设备id 得到相应生命周期",notes="")
    @GetMapping("/list")
    public Response getList(DeviceForm form, Integer id){
        IPage<LifeCycle> device=lifeCycleService.selectList(new Page<LifeCycle>(form.getCurrent(),form.getSize()),id);
        return new ResponseData(device);
    }
}
