package com.mlnx.device_manager.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.common.entity.ResponseData;
import com.mlnx.common.utils.ObjectValidUtil;
import com.mlnx.device_manager.api.ContractService;
import com.mlnx.device_manager.core.entity.ExceptionMsg;
import com.mlnx.device_manager.entity.Contract;
import com.mlnx.device_manager.entity.LifeCycle;
import com.mlnx.device_manager.mappers.TContractMapper;
import com.mlnx.device_manager.mappers.TLifeCycleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceIml implements ContractService {

    @Autowired
    private TContractMapper tContractMapper;

    @Autowired
    private TLifeCycleMapper tLifeCycleMapper;

    @Override
    public Contract getOne(Integer id) {
        return tContractMapper.getOne(id);
    }

    @Override
    public Response selectCNS(IPage<Contract> page, String input) {
        IPage<Contract> device=tContractMapper.selectCNS(page,input);
        //List<Contract>list=device.getRecords();
        //LifeCycle lifeCycle=new LifeCycle();
        //for(Contract c:list){
           // if(tLifeCycleMapper.selectOne(new QueryWrapper<LifeCycle>().eq("device_id",c.getId()).last("limit 1"))==null){
             //   lifeCycle.setDeviceId(c.getId());
               // lifeCycle.setEndPoint(c.getDeliverDate());
                //lifeCycle.setEvent("签订合同发货");
                //lifeCycle.setRemark("无");
                //tLifeCycleMapper.insert(lifeCycle);
            //}
        //}
        return new ResponseData(device);
    }

    @Override
    public List<Contract> selectCIN() {
        return tContractMapper.selectList(new QueryWrapper<Contract>().select("id","numeration"));
    }

    //@Override
    //public List<Map<String, String>> selectContract(Integer current,Integer size) {
    //    return tContractMapper.selectContract(current,size);
    //}

    @Override
    public int insert(Contract contract) {
        return tContractMapper.insert(contract);
    }

    @Override
    public Contract selectById(Integer id) {
        return tContractMapper.selectById(id);
    }

    @Override
    public Contract selectOne(Wrapper queryWrapper) {
        return tContractMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Contract> selectList(Wrapper wrapper) {
        return tContractMapper.selectList(null);
    }

    @Override
    public int deleteById(Integer id) {
        return tContractMapper.deleteById(id);
    }

    @Override
    public int delete(Wrapper wrapper) {
        return tContractMapper.delete(null);
    }

    @Override
    public int updateById(Contract contract) {
        return tContractMapper.updateById(contract);
    }

    @Override
    public int update(Contract contract, Wrapper wrapper) {
        return tContractMapper.update(contract,null);
    }

    @Override
    public Response selectDN(Integer id) {
        if (ObjectValidUtil.isInvalid(id)) {
            return new Response(ExceptionMsg.ParamError);
        }
        List<Contract>device=tContractMapper.selectDN(id);
        if(device.size()==0){
            return new Response(ExceptionMsg.NoDevice.getMsg());
        }
        return new ResponseData(device);
    }

    @Override
    public List<Contract> selectID(Integer id) {
        return tContractMapper.selectID(id);
    }

    @Override
    public List<Contract> getRecords(Integer id) {
        return tContractMapper.getRecords(id);
    }
}
