package com.mlnx.device_manager.mappers;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mlnx.device_manager.entity.Dealer;
import org.apache.ibatis.annotations.Param;

public interface TDealerMapper extends BaseMapper<Dealer> {
    //@Select("select id,dealer_name from t_dealer")
    //List<Dealer> selectDIN();

    //@Select("select id,dealer_name,linkman,phone,address from t_dealer")
    Page<Dealer> selectDR(IPage<Dealer> page, @Param("searchKey") String searchKey);

    //@Select("select id,dealer_name,linkman,phone,address from t_dealer where id=#{id}")
    //Dealer selectDRO(Integer id);


}
