package com.crm.service.finance.impl;

import com.crm.entity.Bill;
import com.crm.mapper.BillMapper;
import com.crm.service.finance.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
