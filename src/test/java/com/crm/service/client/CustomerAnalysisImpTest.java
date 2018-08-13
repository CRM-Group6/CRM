package com.crm.service.client;

import com.crm.entity.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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

    @Test
    public void findAllPossibleRegion() {
        System.out.println(customerService.findAllPossibleRegion());
    }

    @Test
    public void findAllCustomerByRegion() {
        System.out.println(customerService.findAllCustomerByRegion(new Region("GD","GZ","Tianhe")));
    }
}