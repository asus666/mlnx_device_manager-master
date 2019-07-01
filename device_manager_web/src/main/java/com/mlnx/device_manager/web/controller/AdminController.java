package com.mlnx.device_manager.web.controller;

import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.AdminService;
import com.mlnx.device_manager.entity.Admin;
import io.swagger.annotations.ApiOperation;
import org.shan.spring.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

    @Autowired
    private AdminService adminService;



    @ApiOperation(value = "获取管理员",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        Admin device=adminService.selectById(id);
        return new ResponseData(device);
    }

    @ApiOperation(value = "登入", notes = "")
    @GetMapping("/login")
    public Response login(@RequestParam("name") String account, @RequestParam String password) {
        return adminService.login(account,password);
    }

    //@ApiOperation(value = "查询管理员",notes="")
    //@PostMapping(value = "/get")
    //public Response get(Admin admin){
    //    return new ResponseData(admin);
    //}

    @ApiOperation(value = "添加管理员",notes="")
    @GetMapping(value = "/add")
    public Response add(Admin admin){
        return new ResponseData(admin);
    }

    @ApiOperation(value = "修改管理员",notes="")
    @GetMapping(value = "/edit")
    public Response edit(Admin admin){
        return new ResponseData(admin);
    }

    @ApiOperation(value = "删除管理员",notes="")
    @GetMapping(value = "/remove")
    public Response remove(Admin admin){
        return new ResponseData(admin);
    }

}
