package com.crm.service.finance.impl;

import com.crm.entity.Bill;
import com.crm.VO.chart.Chart;
import com.crm.entity.finance.BillStatistic;
import com.crm.service.finance.BillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void selectByTypeAndBalance() {
        List<Bill> bills =billService.selectByTypeAndBalance(0,true);
        System.out.println(bills.size());
    }




    @Test
    public void getBillList() {
        List<Bill> list =billService.getBillList();
        list.size();
    }

    @Test
    public void selectByDate() {
        String year="2018";
        List<BillStatistic> billStatistics= billService.selectByDate(year,1);
        billStatistics.size();
        List<Double> list=new ArrayList<Double>();
        for(int i=0;i<12;i++){
            list.add(new Double(0));
            for(int j=0;j<billStatistics.size();j++){
                int z=Integer.valueOf(billStatistics.get(j).getMonth()).intValue();
                if(z==i){
                    list.set(i,billStatistics.get(j).getMoney());
                }
            }
        }
        Chart chart =new Chart("收支情况",list);
        chart.getData().get(7);
    }
}