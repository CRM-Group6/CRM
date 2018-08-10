package com.crm.service.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {
    @Autowired
    private CustomerService customerService;
    @Test
    public void findAllCustomer() {
        System.out.println(customerService.findAllCustomer());
    }

    @Test
    public void findAllCustomerServiceStaff() {
        System.out.println(customerService.findAllCustomerServiceStaff());
    }
}