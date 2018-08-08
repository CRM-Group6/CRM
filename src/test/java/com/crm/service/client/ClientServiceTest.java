package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.entity.Info;
import com.crm.entity.User;
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
}