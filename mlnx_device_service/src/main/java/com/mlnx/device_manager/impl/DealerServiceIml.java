package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.common.utils.ObjectValidUtil;
import com.mlnx.device_manager.api.DealerService;
import com.mlnx.device_manager.core.entity.ExceptionMsg;
import com.mlnx.device_manager.core.entity.MD5Util;
import com.mlnx.device_manager.entity.Dealer;
import com.mlnx.device_manager.mappers.TDealerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerServiceIml implements DealerService {
    @Autowired
    private TDealerMapper tDealerMapper;

    @Override
    public Response login(String phone, String password) {
        if (ObjectValidUtil.isInvalid(phone, password)) {
            return new Response(ExceptionMsg.ParamError);
        }

        String md5Pwd= MD5Util.string2MD5(password);
        Dealer dealer=tDealerMapper.selectOne(new QueryWrapper<Dealer>().select("id","dealer_name","password").eq("phone",phone));
                //eq("phone",phone).last("limit 1"));
        if(phone.matches("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$")){
            if(ObjectValidUtil.isInvalid(dealer)){
                return new ResponseData("该经销商账号不存在");
            }
            if(!(dealer.getPassword().equals(md5Pwd))){
                return new ResponseData("密码不正确");
            }
        }else{
            return new ResponseData("号码格式不正确");
        }
        return new ResponseData(dealer);
    }

    @Override
    public IPage<Dealer> selectDR(IPage<Dealer> page, String searchKey) {
        return tDealerMapper.selectDR(page,searchKey);
    }

    @Override
    public Dealer selectDRO(Integer id) {
        return  tDealerMapper.selectOne(new QueryWrapper<Dealer>().select("dealer_name","address","linkman","phone").eq("id",id));
    }

    @Override
    public List<Dealer> selectDIN() {
        return tDealerMapper.selectList(new QueryWrapper<Dealer>().select("id","dealer_name"));
    }

    @Override
    public IPage selectPage(IPage<Dealer> page, Wrapper<Dealer> wrapper) {
        return tDealerMapper.selectPage(page,new QueryWrapper<Dealer>().isNull("password"));
    }

    @Override
    public int insert(Dealer dealer) {
        String md5Password= MD5Util.string2MD5(dealer.getPassword());
        dealer.setPassword(md5Password);
        return tDealerMapper.insert(dealer);
    }

    @Override
    public Dealer selectById(Integer id) {
        return tDealerMapper.selectById(id);
    }

    @Override
    public Dealer selectOne(Wrapper queryWrapper) {
        return tDealerMapper.selectOne(null);
    }

    @Override
    public List<Dealer> selectList(Wrapper wrapper, String password) {
        return tDealerMapper.selectList(new QueryWrapper<Dealer>().eq(false,"password",password));
    }

    @Override
    public int deleteById(Integer id) {
        return tDealerMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tDealerMapper.delete(null);
    }

    @Override
    public int updateById(Dealer dealer) {

        return tDealerMapper.updateById(dealer);
    }

    @Override
    public int update(Dealer dealer, Wrapper wrapper) {
        return tDealerMapper.update(dealer,null);
    }

}
