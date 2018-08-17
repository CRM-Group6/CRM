package com.crm.service.sale;

import com.crm.entity.CustomerStatistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by JackKo
 * 2018/8/9 21:34
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAnalyServiceTest {

    @Autowired
    private CustomerAnalysisService customerAnalysisService;

    @Test
    public void findAll() {
        List<CustomerStatistics> result = customerAnalysisService.findAll();
        System.out.println("客户统计：" + result);
    }
}