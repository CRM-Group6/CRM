package com.crm.service.client;


import com.crm.entity.*;
import com.crm.enums.InfoType;
import com.crm.mapper.BillMapper;
import com.crm.mapper.InfoMapper;
import com.crm.mapper.OrderListMapper;
import com.crm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ben wu
 * @Date 2018/8/9
 * @Description 用于客户基本界面的模块的业务逻辑
 */
@Service
public class ClientService {

    @Autowired
    private InfoMapper infoMapper;
    @Autowired
    private BillMapper billMapper;
    @Autowired
    private OrderListMapper orderListMapper;
    @Autowired
    private UserMapper userMapper;
    //查看商旅咨询
    public List<Info> findTravelInfo(){
        return infoMapper.selectInfoByUserID(InfoType.TRAVEL.getIndex());
    }
    //查看特价信息
    public List<Info> findBargainInfo(){
        return infoMapper.selectInfoByUserID(InfoType.BARGAIN.getIndex());
    }
    //查看通告
    public List<Info> findBroadCastInfo(){
        return infoMapper.selectInfoByUserID(InfoType.BROADCAST.getIndex());
    }
    //查看用户订单
    public List<OrderList> findAllOrderList(Customer customer){
        return orderListMapper.selectByCustomerID(customer);
    }
    //查看用户账单
    public List<Bill> findAllBill(Customer customer){
        return billMapper.selectBillByCustomerID(customer);
    }
    //查找专员客服人员
    public User findCustomerServiceStaff(Customer customer){
        return userMapper.selectByCustomerID(customer);
    }
}
