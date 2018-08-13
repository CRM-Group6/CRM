package com.crm.controller.sys.sale;

import com.crm.entity.WorkPlan;
import com.crm.service.sale.WorkPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 销售提醒：查看工作时间计划表
 * Created by JackKo
 * 2018/8/13 10:34
 **/
@RestController
@RequestMapping("/sale/saleRemind")
public class SelectWorkPlanController {

    @Autowired
    private WorkPlanService workPlanService;

    @GetMapping("/seeWorkPlan/{id}")
    public WorkPlan seeWorkPlan(@PathVariable("id") Long id){
        return workPlanService.findOne(id);
    }

}
