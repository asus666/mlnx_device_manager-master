package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.Contract;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TContractMapper extends BaseMapper<Contract> {
    //@Select("select a.numeration,b.dealer_name,c.hospital_name,a.deliver_date,a.signer,a.remark from t_contract a LEFT JOIN t_dealer b on a.dealer_id=b.id LEFT JOIN t_user c on a.hospital_id=c.id limit #{current},#{size}")
    //List<Map<String,String>> selectContract(Integer current,Integer size);

    //@Select("select id,numeration from t_contract")
    //List<Map<Integer,String>> selectCIN();

    //@Select("select a.numeration,b.dealer_name,c.hospital_name,a.deliver_date,a.signer,a.remark from t_contract a LEFT JOIN t_dealer b on a.contract_id=b.id LEFT JOIN t_user c on a.hospital_id=c.id where a.numeration like concat ('%',#{searchKey},'%') or a.signer like concat ('%',#{searchKey},'%') ")
    Page<Contract> selectCNS(IPage<Contract> page, String searchKey);

    //@Select("select a.id,a.numeration,b.dealer_name,c.hospital_name,a.deliver_date,a.signer,a.remark,b.id dealer_id,c.id hospital_id from t_contract a LEFT JOIN t_dealer b on a.dealer_id=b.id LEFT JOIN t_user c on a.hospital_id=c.id where a.id=#{id}")
    Contract getOne(Integer id);

    @Select("select b.numeration from t_contract a left join t_device b on a.id=b.contract_id where a.id=#{id} and b.numeration is not null")
    List<Contract> selectDN(Integer id);

    @Select("select b.id from t_contract a left join t_device b on a.id=b.contract_id where a.id=#{id}")
    List<Contract> selectID(Integer id);

    //@Select("select count(*)  from t_contract a left join t_device b on a.id=b.contract_id where a.id=#{id} and b.numeration is not null")
    //Integer selectDNC(Integer id);

    @Select("select deliver_date,a.numeration,(case  when a.state is null then '无' else '空的' end)state,a.remark from t_contract a left join t_device b on a.id=b.contract_id where b.id=#{deviceId}")
    List<Contract> getRecords(Integer deviceId);
}
