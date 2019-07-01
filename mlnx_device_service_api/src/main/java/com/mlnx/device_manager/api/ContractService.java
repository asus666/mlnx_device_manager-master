package com.mlnx.device_manager.api;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mlnx.common.entity.Response;
import com.mlnx.device_manager.entity.Contract;

import java.util.List;

public interface ContractService {
    int insert(Contract contract);
    Contract selectById(Integer id);
    Contract selectOne(Wrapper queryWrapper);
    List<Contract> selectList(Wrapper wrapper);
    int deleteById(Integer id);
    int delete(Wrapper wrapper);
    int updateById(Contract contract);
    int update(Contract contract, Wrapper wrapper);
    List<Contract> selectID(Integer id);
    List<Contract> selectCIN();
    Response selectCNS(IPage<Contract> page, String searchKey);
    Contract getOne(Integer id);
    Response selectDN(Integer id);
    //Integer selectDNC(Integer id);
    List<Contract> getRecords(Integer deviceId);
}
