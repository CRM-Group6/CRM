package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.Opportunity;
import com.crm.entity.WorkPlan;
import com.crm.service.sale.OpportunityService;
import com.crm.service.sale.WorkPlanService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 开发计划管理
 * Created by JackKo
 * 2018/8/13 10:31
 **/
@RestController
@RequestMapping("/sale/developmentPlan")
public class DevelopmentPlanManageController {
    @Autowired
    private WorkPlanService workPlanService;

    //制定开发计划
    //增加开发计划
    @GetMapping("/add/{id}")
    public int create(WorkPlan workPlan , @PathVariable Long id){
        workPlan.setOpportunityId(id);
        return workPlanService.addWorkPlan(workPlan);
    }


    //执行开发计划(修改开发状态)
    //修改开发计划
    @GetMapping("/change")
    public int change(WorkPlan workPlan){
        return workPlanService.changeWorkPlan(workPlan);
    }


    //删除开发计划
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable Long id){
        return workPlanService.deleteWorkPlan(id);
    }

    //查看所有开发计划
    @GetMapping("/see")
    public ResultVO seeAll(){
        return ResultVOUtil.success(workPlanService.findAll());
    }

    //查看单个开发计划
    @GetMapping("/see/{id}")
    public ResultVO seeOne(@PathVariable Long id){
        return ResultVOUtil.success(workPlanService.findOne(id));
    }
}
