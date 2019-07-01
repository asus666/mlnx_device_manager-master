package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by amanda.shan on 2018/11/1.
 */


public interface TUserMapper extends BaseMapper<User> {
    //@Select("select dealer_name from t_dealer a left join t_user b on a.id=b.dealer_id where a.id=#{id}")
    //List<Map> matchDealer(Integer id);
    @Select("select a.id,a.hospital_name hospitalName from t_user a left join t_dealer b on a.dealer_id=b.id where a.dealer_id=#{id} ")
    List<User> selectUIN(Integer dealerId);

    //@Select("select a.name,a.linkman,a.hospital_name,a.address,b.dealer_name from t_user a left join t_dealer b on a.dealer_id=b.id limit #{current},#{size}")
    Page<User> selectHP(IPage<User> page, @Param("searchKey") String searchKey, @Param("dealerId") Integer dealerId);


    @Select("select a.id,a.name,a.linkman,a.hospital_name,a.address,b.dealer_name,a.isnative,b.id dealer_id from t_user a left join t_dealer b on a.dealer_id=b.id where a.id=#{id}")
    User selectHPO(Integer id);
}
