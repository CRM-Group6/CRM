package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.entity.User;
import com.crm.enums.Department;
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

    @Test
    public void setCustomerServiceStaff() {
        Customer customer = new Customer();
        customer.setId(2L);
        User user = new User();
        user.setId(2L);
        user.setDepartment(Department.CUSTOMER_SERVICE.getIndex());
        customerService.setCustomerServiceStaff(customer,user);
    }
}