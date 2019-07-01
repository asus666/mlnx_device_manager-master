package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.UserService;
import com.mlnx.device_manager.core.entity.ExceptionMsg;
import com.mlnx.device_manager.entity.User;
import com.mlnx.device_manager.pojo.vo.form.DeviceForm;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.shan.spring.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by amanda.shan on 2019/1/30.
 */
@RestController

@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userServiceIml;
    //@Value("哈哈天下武功唯快不破")
    //private String salt;

    @ApiOperation(value = "登入", notes = "")
    @GetMapping("/login")
    public Response login(@RequestParam String name, @RequestParam String password) {
        return userServiceIml.login(name,password);
    }


    @ApiOperation(value="根据经销商id 获得医院列表（只有id name）",notes="")
    @GetMapping("/list")
    public Response list(Integer id){
        List<User> device=userServiceIml.selectUIN(id);
        return new ResponseData(device);
    }



    @ApiOperation(value = "获取单个医院数据",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        User device =userServiceIml.selectHPO(id);
        return new ResponseData(device);
    }

    //@ApiOperation(value = "医院分页数据",notes="")
    //@ApiImplicitParams({
    //        @ApiImplicitParam(name = "current", value = "当前页序号", required = true, dataType = "Integer"),
    //        @ApiImplicitParam(name = "size", value = "每页条数", required = true, dataType = "Integer"),
    //})
    //@GetMapping("/getPageList")
    //public Response page( Integer current, Integer size){
    //    IPage<User> pageList=userServiceIml.selectPage(new Page<User>(current,size),null);
    //    return new ResponseData(pageList);
    //}

    @ApiOperation(value = "根据单位名称 联系人 电话的医院分页数据",notes="")
    @GetMapping("/getPageList")
    public Response page(DeviceForm form, Integer dealerId){
       IPage<User> pageList=userServiceIml.selectHP(new Page<User>(form.getCurrent(),form.getSize()),form.getSearchKey(),dealerId);
        return new ResponseData(pageList);
    }

    //@ApiOperation(value = "根据经销商id取得经销商名称",notes = "")
    //@GetMapping("/matchDealer")
    //public Response matchDealer(Integer id){
    //    List<Map> maps=userServiceIml.matchDealer(id);
    //    return new ResponseData(maps);
    //}



    @ApiOperation(value ="新增医院",notes="")
    @GetMapping("/add")
    public Response add(User user){
        //producer.setBpPushId(bpPushId);
        //producer.setBsPushId(bsPushId);
        List<User> u= userServiceIml.selectList(new QueryWrapper<User>().eq("name",user.getName()));
        if(u.size()==0) {
            userServiceIml.insert(user);
            return new ResponseData("注册成功");
        }
        return  result(ExceptionMsg.DupName.getMsg());
    }

    @ApiOperation(value ="编辑医院",notes="")
    @GetMapping("/edit")
    public Response edit(User user){
        userServiceIml.updateById(user);
        return new ResponseData("信息修改成功");
    }

    @ApiOperation(value ="删除医院",notes="")
    @GetMapping("/remove")
    public Response remove(Integer id){
        userServiceIml.deleteById(id);
        return new ResponseData("删除成功");
    }

}
