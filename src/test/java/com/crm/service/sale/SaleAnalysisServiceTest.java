package com.crm.service.sale;

import com.crm.entity.SalesRecords;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by JackKo
 * 2018/8/9 21:55
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class SaleAnalysisServiceTest {

    @Autowired
    private SaleAnalysisService saleAnalysisService;

    @Test
    public void findByDepartment() {
        List<SalesRecords> result = saleAnalysisService.findByDepartment();
        System.out.println("业绩分析根据部门：" + result);
    }

    @Test
    public void findByWorker() {
        List<SalesRecords> result = saleAnalysisService.findByWorker();
        System.out.println("业绩分析根据人员：" + result);
    }


    @Test
    public void findByDepartmentOpportunity() {
        List<SalesRecords> result = saleAnalysisService.findByDepartmentOpportunity();
        System.out.println("机会分析根据部门：" + result);
    }

    @Test
    public void findByWorkerOpportunity() {
        List<SalesRecords> result = saleAnalysisService.findByWorkerOpportunity();
        System.out.println("机会分析根据人员：" + result);
    }
}