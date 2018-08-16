package com.crm.service.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 11:33 2018/8/13
 * @Modify By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerAnalysisImpTest {
    @Autowired
    private CustomerAnalysisImp customerService;
    @Test
    public void customerRegionAnalysis() {
        System.out.println(customerService.customerRegionAnalysis());
    }

    @Test
    public void customerSourceAnalysis() {
        System.out.println(customerService.customerSourceAnalysis());
    }

    @Test
    public void customerIndustryAnalysis() {
        System.out.println(customerService.customerIndustryAnalysis());
    }

}