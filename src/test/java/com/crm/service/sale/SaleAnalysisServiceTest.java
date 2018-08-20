package com.crm.service.sale;

import com.crm.VO.SaleShow;
import com.crm.VO.ScatterData;
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
        List<SaleShow> result = saleAnalysisService.findByDepartment();
        System.out.println("业绩分析根据部门：" + result);
    }

    @Test
    public void findByWorker() {
        List<SaleShow> result = saleAnalysisService.findByWorker();
        System.out.println("业绩分析根据人员：" + result);
    }


    @Test
    public void findByDepartmentOpportunity() {
        List<SaleShow> result = saleAnalysisService.findByDepartmentOpportunity();
        System.out.println("机会分析根据部门：" + result);
    }

    @Test
    public void findByWorkerOpportunity() {
        List<SaleShow> result = saleAnalysisService.findByWorkerOpportunity();
        System.out.println("机会分析根据人员：" + result);
    }
}