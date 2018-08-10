package com.crm.service.sale;

import com.crm.entity.WorkPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JackKo
 * 2018/8/9 10:46
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class WorkPlanServiceTest {

    @Autowired
    private WorkPlanService workPlanService;

    @Test
    public void addWorkPlan() {
       WorkPlan newPlan = new WorkPlan();
       newPlan.setId(new Long((long)3));
       newPlan.setOpportunityId(new Long((long)2));
       newPlan.setExecutorId(new Long((long)2));
       int result = workPlanService.addWorkPlan(newPlan);
       System.out.println("添加状态" + result);
    }

    @Test
    public void changeWorkPlan() {
        WorkPlan changePlan = new WorkPlan();
        changePlan.setId(new Long((long)1));
        changePlan.setOpportunityId(new Long((long)3));
        int result2 = workPlanService.changeWorkPlan(changePlan);
        System.out.println("修改状态" + result2);
    }

    @Test
    public void deleteWorkPlan() {
        int result3 = workPlanService.deleteWorkPlan(new Long((long)3));
        System.out.println("删除状态" + result3);
    }

    @Test
    public void findOne() {
        WorkPlan result4 = workPlanService.findOne(new Long((long)2));
        System.out.println(result4.getOpportunityId());
    }

    @Test
    public void findAll() {
        List<WorkPlan> list = workPlanService.findAll();
        System.out.println("显示：" + list.toString());

    }
}