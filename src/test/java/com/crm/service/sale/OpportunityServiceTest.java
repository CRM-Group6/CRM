package com.crm.service.sale;

import com.crm.entity.Opportunity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JackKo
 * 2018/8/8 17:10
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityServiceTest {

    @Autowired
    private OpportunityService opportunityService;

    @Test
    public void addOpportunity() {
        Opportunity newOpp = new Opportunity();
        newOpp.setId(new Long((long)3));
        newOpp.setAssignedSalesmanId(new Long((long)2));
        newOpp.setSalesmanId(new Long((long)2));
        newOpp.setClientName("vnadv");
        newOpp.setContactId(new Long((long) 1));
        int row = opportunityService.addOpportunity(newOpp);
        System.out.println("插入" + row + "行");
    }

    @Test
    public void changeOpportunity() {
        Opportunity newOpp = new Opportunity();
        newOpp.setId(new Long((long)3));
        newOpp.setAssignedSalesmanId(new Long((long)2));
        newOpp.setSalesmanId(new Long((long)2));
        newOpp.setClientName("ling");
        newOpp.setContactId(new Long((long) 1));
        int change = opportunityService.changeOpportunity(newOpp);
        System.out.println("修改" + change + "行");
    }

    @Test
    public void findOne() {
        Long id = new Long((long)1);
        Opportunity opportunity = opportunityService.findOne(id);
        System.out.println("客户名是：" + opportunity.getClientName());
    }

    @Test
    public void findAll() {
        List<Opportunity> allOpp = opportunityService.findAll();
        System.out.println("全部的机会" + allOpp.size());

    }

    @Test
    public void deleteOpportunity() {
        int row = opportunityService.deleteOpportunity(new Long((long)1));
        System.out.println(row);
    }
}