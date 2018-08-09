package com.crm.service.sale;

import com.crm.entity.SalesRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JackKo
 * 2018/8/9 21:55
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleAnalyServiceTest {

    @Autowired
    private SaleAnalyService saleAnalyService;

    @Test
    public void findByDepartment() {
        List<SalesRecords> result = saleAnalyService.findByDepartment();
        System.out.println("业绩分析根据部门：" + result);
    }

    @Test
    public void findByWorker() {
        List<SalesRecords> result = saleAnalyService.findByWorker();
        System.out.println("业绩分析根据人员：" + result);
    }


    @Test
    public void findByDepartmentOpportunity() {
        List<SalesRecords> result = saleAnalyService.findByDepartmentOpportunity();
        System.out.println("机会分析根据部门：" + result);
    }

    @Test
    public void findByWorkerOpportunity() {
        List<SalesRecords> result = saleAnalyService.findByWorkerOpportunity();
        System.out.println("机会分析根据人员：" + result);
    }
}