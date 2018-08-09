package com.crm.service.client;


import com.crm.entity.Bill;
import com.crm.entity.Customer;
import com.crm.entity.Info;
import com.crm.entity.User;
import com.crm.enums.InfoType;
import com.crm.mapper.BillMapper;
import com.crm.mapper.InfoMapper;
import com.crm.mapper.OrderListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private InfoMapper infoMapper;
    @Autowired
    private BillMapper billMapper;
    //查看商旅咨询
    public List<Info> findTravelInfo(Customer customer){
        return infoMapper.selectInfoByUserID(customer.getId(),InfoType.TRAVEL.getCode());
    }
    //查看特价信息
    public List<Info> findBargainInfo(Customer customer){
        return infoMapper.selectInfoByUserID(customer.getId(),InfoType.BARGAIN.getCode());
    }
    //查看通告
    public List<Info> findBroadCastInfo(Customer customer){
        return infoMapper.selectInfoByUserID(customer.getId(),InfoType.BROADCAST.getCode());
    }
    //查看用户订单
    public List<Bill> findAllOrderList(Customer customer){
        return null;
    }
    //查看用户账单
    public List<Bill> findAllBill(Customer customer){
        return billMapper.selectBillByCustomerID(customer);
    }
    //查找专员客服人员
    public User findCustomerServiceStaff(Customer customer){
        return null;
    }
}
