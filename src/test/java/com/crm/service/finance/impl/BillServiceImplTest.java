package com.crm.service.finance.impl;

import com.crm.entity.Bill;
import com.crm.mapper.BillMapper;
import com.crm.service.finance.BillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceImplTest {
    @Autowired
    private BillService billService;
    @Test
    public void insertBill() {

    }

    @Test
    public void updateBill() {
        Bill bill=new Bill();
        bill.setId(new Long(123));
        bill.setOrderId(new Long(111));
        bill.setContractId(new Long(12));
        bill.setCustomerId(new Long(11));
        bill.setAmmount((double) 1);
        bill.setRemark("hello");
        billService.updateBill(bill);
    }

    @Test
    public void deleteBill() {
        Long id = new Long((long)12);
        int a=billService.deleteBill(id);
        System.out.println(a);
    }
    @Test
    public void selectByType(){
        List<Bill> list=billService.selectByType(1);
        System.out.println(list.size());
    }
    @Test
    public void selectByBalace(){
        List<Bill> list=billService.selectByBalance(true);
        System.out.println(list.size());
    }

    @Test
    public void settleBill() {
        Bill bill=new Bill();
        bill.setId(new Long(123));
        bill.setOrderId(new Long(111));
        bill.setContractId(new Long(12));
        bill.setCustomerId(new Long(11));
        bill.setAmmount((double) 1);
        bill.setRemark("test");
        billService.settleBill(bill);
    }
}