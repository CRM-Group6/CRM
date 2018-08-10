package com.crm.service.sale;

import com.crm.entity.CustomerStatistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JackKo
 * 2018/8/9 21:34
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAnalyServiceTest {

    @Autowired
    private CustomerAnalyService customerAnalyService;

    @Test
    public void findAll() {
        List<CustomerStatistics> result = customerAnalyService.findAll();
        System.out.println("客户统计：" + result);
    }
}