package com.crm.controller.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.WorkPlan;
import com.crm.service.sale.WorkPlanService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add")
    public ResultVO create(@RequestBody WorkPlan workPlan ){
//        workPlan.setOpportunityId(id);
        int res = workPlanService.addWorkPlan(workPlan);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }


    //执行开发计划(修改开发状态)
    //修改开发计划
    @PutMapping("/change")
    public ResultVO change(@RequestBody WorkPlan workPlan){

        int res = workPlanService.changeWorkPlan(workPlan);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }


    //删除开发计划
    @DeleteMapping("/delete/{id}")
    public ResultVO delete(@PathVariable Long id){

        int res = workPlanService.deleteWorkPlan(id);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }

    //查看所有开发计划
    @GetMapping("/see")
    public ResultVO seeAll(){

        List<WorkPlan> workPlanList = workPlanService.findAll();
        if(workPlanList == null) return ResultVOUtil.error();
        return ResultVOUtil.success(workPlanList);
    }

    //查看单个开发计划
    @GetMapping("/see/{id}")
    public ResultVO seeOne(@PathVariable Long id){
        WorkPlan workPlanList = workPlanService.findOne(id);
        if(workPlanList == null) return ResultVOUtil.error();
        return ResultVOUtil.success(workPlanList);
    }
}
