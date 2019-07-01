package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.Device;
import org.apache.ibatis.annotations.Param;

public interface TDeviceMapper extends BaseMapper<Device> {


    //根据设备类型 分頁 显示设备名称
    Page<Device> selectDevice(IPage<Device> page, @Param("deviceTypeId") Integer deviceTypeId, @Param("searchKey") String searchKey);

    //根据单个设备id 得到单条信息
    Device getOne(Integer id);

    //搜索
    //@Select("select a.id,a.numeration,a.mcu_id,a.mac_address,a.transmission_type,b.`name`,a.production_time,c.dealer_name,d.hospital_name,f.numeration from t_device a,t_producer b,t_dealer c,t_user d,t_device_type e,t_contract f where a.device_type_id=#{deviceTypeId}  and a.numeration like concat('%',#{searchKey},'%') or b.name like concat('%',#{searchKey},'%') or c.dealer_name like concat('%',#{searchKey},'%')")
    //@Select("select a.id,a.numeration,a.mcu_id,a.mac_address,a.transmission_type,b.`name`,a.production_time,c.dealer_name,d.hospital_name,f.numeration from t_device a LEFT JOIN t_producer b on a.producer_id=b.id left join t_dealer c on a.dealer_id=c.id LEFT JOIN t_user d on a.hospital_id=d.id left JOIN t_device_type e on a.device_type_id=e.id LEFT JOIN t_contract f on a.contract_id=f.id where  a.device_type_id=#{deviceTypeId} and (a.numeration like concat('%',#{searchKey},'%') or b.name like concat('%',#{searchKey},'%') or c.dealer_name like concat('%',#{searchKey},'%')) ")
   // Page<Device>selectNPD(IPage<Device> page,@Param("deviceTypeId") Integer deviceTypeId,@Param("searchKey") String searchKey);

    //@Select("select a.id,a.numeration,a.mcu_id,a.mac_address,a.transmission_type,b.`name`,a.production_time,c.dealer_name,d.hospital_name,f.numeration from t_device a LEFT JOIN t_producer b on a.producer_id=b.id left join t_dealer c on a.dealer_id=c.id LEFT JOIN t_user d on a.hospital_id=d.id left JOIN t_device_type e on a.device_type_id=e.id LEFT JOIN t_contract f on a.contract_id=f.id where a.dealer_id=#{dealerId} and a.device_type_id=#{id} limit #{current},#{size}")
    Page<Device> selectDeviceByDealer(IPage<Device> page, @Param("deviceTypeId") Integer deviceTypeId, @Param("dealerId") Integer dealerId, @Param("searchKey") String searchKey);

    //@Select("select a.id,a.numeration,a.mcu_id,a.mac_address,a.transmission_type,b.`name`,a.production_time,c.dealer_name,d.hospital_name,f.numeration from t_device a LEFT JOIN t_producer b on a.producer_id=b.id left join t_dealer c on a.dealer_id=c.id LEFT JOIN t_user d on a.hospital_id=d.id left JOIN t_device_type e on a.device_type_id=e.id LEFT JOIN t_contract f on a.contract_id=f.id where a.hospital_id=#{hospitalId} and a.device_type_id=#{id} limit #{current},#{size}")
    Page<Device> selectDeviceByUser(IPage<Device> page, @Param("deviceTypeId") Integer deviceTypeId, @Param("hospitalId") Integer hospitalId, @Param("searchKey") String searchKey);

    //@Select("select production_time,numeration,(case  when a.state is null then 0 else '空的' end)state from t_device a where a.id=#{deviceId}")
    //Device getRecords(Integer deviceId);

    //@Select("select count(*) a from t_device a LEFT JOIN t_producer b on a.producer_id=b.id left join t_dealer c on a.dealer_id=c.id LEFT JOIN t_user d on a.hospital_id=d.id left JOIN t_device_type e on a.device_type_id=e.id LEFT JOIN t_contract f on a.contract_id=f.id where a.device_type_id=#{id}")
     //Integer selectDeviceCount(Integer id,String searchKey);

    //List<Map<String,String>> selectBatchDealer(Integer[]ids);
    //根据经销商id 显示各设备名称
    //@Select("")

    //@Select("select transmission_type from t_device")
    //List<Map<String,String>> selectTransmission();
    //新增设备中用到的


    //出厂信息 producer_id
    //@Select("select name from t_producer a left join t_device b on a.id=b.producer_id where a.id=#{id}")
    //List<Map<String,String>> selectPN(Integer id);
    //
    //
    ///医院名称 hospital_id
    //@Select("select hospital_name from t_user a left join t_dealer b on a.dealer_id=b.id left join t_device c on a.dealer_id=c.dealer_id where a.dealer_id=#{id}")
    //List<Map<String,String>> selectHNL(Integer id);
    //
    //
    ////设备类型 device_type_id
    //@Select("select name from t_device a left join t_device_type b on a.device_type_id=b.id where a.device_type_id=#{id}")
    //List<Map<String,String>> selectDT(Integer id);

    ////合同编号
    //@Select("select a.numeration from t_contract a left join t_device b on a.id=b.contract_id where b.contract_id=#{id}")
    //String selectCN(Integer id);
    //更新指定设备的经销商 医院 合同
}
