package com.crm.service.finance;

import com.crm.entity.Bill;

import java.util.List;

public interface BillService {
    Bill findBill(Long id);             //查找单个账单
    int insertBill(Bill bill);          //插入账单
    int updateBill(Bill bill);          //更新账单
    int deleteBill(Long id);            //删除账单
    List<Bill> selectByType(Integer type);//账单类型查询
    List<Bill> selectByBalance(Boolean balance);//账单状态查询
    int settleBill(Bill bill);          //账单结算
    List<Bill> selectByTypeAndBalance(Integer type ,Boolean balance);
}

