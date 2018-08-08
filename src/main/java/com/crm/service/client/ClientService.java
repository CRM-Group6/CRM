package com.crm.service.client;


import com.crm.entity.Customer;
import com.crm.entity.Info;
import com.crm.entity.User;
import com.crm.enums.InfoType;
import com.crm.mapper.InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private InfoMapper infoMapper;
    //查看商旅咨询
    public List<Info> findTravelInfo(Customer customer){
        return infoMapper.selectInfoByUserID(customer.getId(),InfoType.TRAVEL.getCode());
    }
    //查看特价信息
    public List<Info> findBarginInfo(Customer customer){
        return null;
    }
    //查看通告

    //查看用户订单

    //查看用户账单

    //联系客服人员

}
