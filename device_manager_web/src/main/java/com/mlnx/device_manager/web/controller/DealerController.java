package com.mlnx.device_manager.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.device_manager.api.DealerService;
import com.mlnx.device_manager.entity.Dealer;
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

@RestController
@RequestMapping(value = "/dealer")
public class DealerController extends BaseController {
    @Autowired
    private DealerService dealerServiceIml;
    //@Value("哈哈天下武功唯快不破")
    //private String salt;
    @ApiOperation(value = "登入", notes = "")
    @GetMapping("/login")
    public Response login(@RequestParam("name") String phone, @RequestParam String password) {
        return dealerServiceIml.login(phone,password);
    }



    //@ApiOperation(value="获得经销商只有id name",notes="")
    //@GetMapping("/getlist")
    //public Response getlist(HttpSession session){
    //    User user=(User)session.getAttribute("user");
    //    String password=user.getPassword();
    //    List<Dealer> device= dealerServiceIml.selectList(new QueryWrapper().eq(false,"password",password),password);
    //    return new ResponseData(device);
    //}



    @ApiOperation(value="获得经销商只有id name",notes="")
    @GetMapping("/list")
    public Response list(){
        List<Dealer> device= dealerServiceIml.selectDIN();
        return new ResponseData(device);
    }

    @ApiOperation(value = "根据单位名称 联系人 电话经销商分页数据",notes="")
    @GetMapping("/getPageList")
    public Response page(DeviceForm form){
        IPage<Dealer> pageList=dealerServiceIml.selectDR(new Page<Dealer>(form.getCurrent(),form.getSize()),form.getSearchKey());
        return new ResponseData(pageList);
    }

    @ApiOperation(value = "获取单个经销商",notes = "")
    @GetMapping("/get")
    public Response get(Integer id){
        Dealer device=dealerServiceIml.selectDRO(id);
        return new ResponseData(device);
    }

    @ApiOperation(value ="新增经销商",notes="")
    @GetMapping("/add")
    public Response addDealer(Dealer dealer){
        dealerServiceIml.insert(dealer);
        return new ResponseData("添加成功");
    }

    @ApiOperation(value ="经销商编辑",notes="")
    @GetMapping("/edit")
    public Response edit(Dealer dealer){
        dealerServiceIml.updateById(dealer);
        return new ResponseData("修改成功");
    }

    @ApiOperation(value ="经销商删除",notes="")
    @GetMapping("/remove")
    public Response remove(Integer id){
        dealerServiceIml.deleteById(id);
        return new ResponseData("删除成功");
    }
}
