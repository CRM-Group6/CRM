package com.crm.service.finance.impl;

import com.crm.entity.Bill;
import com.crm.entity.finance.BillStatistic;
import com.crm.enums.finance.BillStatusEnum;
import com.crm.enums.finance.BillTypeEnum;
import com.crm.mapper.BillMapper;
import com.crm.service.finance.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;
    @Override
    public Bill findBill(Long id) {

        return billMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertBill(Bill bill) {

        return billMapper.insert(bill);
    }

    @Override
    public int updateBill(Bill bill) {

        return billMapper.updateByPrimaryKey(bill);
    }
    @Override
    public int deleteBill(Long id) {

        return billMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Bill> selectByType(Integer type) {
        return billMapper.selectByType(type);
    }

    @Override
    public List<Bill> selectByBalance(Boolean balance) {
        return billMapper.selectByBalance(balance);
    }

    @Override
    public int settleBill(Bill bill) {
        Bill oldbill=billMapper.selectByPrimaryKey(bill.getId());
        if(oldbill.getAmmount().equals(bill.getAmmount())){
            bill.setBalance(BillStatusEnum.CLOSED.getCode());
            return billMapper.updateByPrimaryKey(bill);
        }
       return 0;
    }

    @Override
    public List<Bill> selectByTypeAndBalance(Integer type, Boolean balance) {
        return billMapper.selectByTypeAndBalance(type,balance);
    }

    @Override
    public BillStatistic selectByDate(Date date, Integer type) {
        return billMapper.selectByDate(date,type);
    }
}
