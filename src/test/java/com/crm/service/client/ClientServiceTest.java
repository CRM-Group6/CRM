package com.crm.service.client;

import com.crm.entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;
    @Test
    public void findTravelInfo() {
        Customer user = new Customer();
        user.setId(1L);
        List<Info> list = clientService.findTravelInfo(user);
        System.out.print(list);
    }

    @Test
    public void findBargainInfo() {
        Customer user = new Customer();
        user.setId(1L);
        List<Info> list = clientService.findBargainInfo(user);
        System.out.print(list);
    }

    @Test
    public void findBroadCastInfo() {
        Customer user = new Customer();
        user.setId(1L);
        List<Info> list = clientService.findBroadCastInfo(user);
        System.out.print(list);
    }

    @Test
    public void findAllOrderList() {
        Customer user = new Customer();
        user.setId(1L);
        List<OrderList> list = clientService.findAllOrderList(user);
        System.out.print(list);
    }

    @Test
    public void findAllBill() {
        Customer user = new Customer();
        user.setId(1L);
        List<Bill> list = clientService.findAllBill(user);
        System.out.print(list);
    }

    @Test
    public void findCustomerServiceStaff() {
        Customer user = new Customer();
        user.setId(1L);
        User staff = clientService.findCustomerServiceStaff(user);
        System.out.print(staff);
    }
}