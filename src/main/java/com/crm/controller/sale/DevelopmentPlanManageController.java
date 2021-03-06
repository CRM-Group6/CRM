package com.crm.controller.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.WorkPlan;
import com.crm.service.sale.WorkPlanService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/add")
    public ModelAndView create(WorkPlan workPlan ){
//        workPlan.setOpportunityId(id);
        workPlanService.addWorkPlan(workPlan);
        return new ModelAndView("redirect:/sale/developmentPlan/see");
    }
    @RequestMapping("/toAdd")
    public ModelAndView goAddUI(){
        return new ModelAndView("/sale/develop_plan_management_add");
    }

    //执行开发计划(修改开发状态)
    //修改开发计划
    @RequestMapping("/change")
    public ModelAndView change( WorkPlan workPlan){
        System.out.println(workPlan);
        int res = workPlanService.changeWorkPlan(workPlan);
        return new ModelAndView("redirect:/sale/developmentPlan/see");
    }


    //删除开发计划
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id){
        workPlanService.deleteWorkPlan(id);
        return new ModelAndView("redirect:/sale/developmentPlan/see");
    }

    //查看所有开发计划
    @GetMapping("/see")
    public ModelAndView seeAll(){
        ModelAndView model = new ModelAndView("/sale/develop_plan_manage");
        List<WorkPlan> workPlanList = workPlanService.findAll();
        if(workPlanList == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(workPlanList));
    }

    //查看单个开发计划
    @GetMapping("/check")
    public ModelAndView seeOne(@RequestParam("id") Long id){
        ModelAndView model = new ModelAndView("/sale/develop_plan_management_edit");
        WorkPlan workPlanList = workPlanService.findOne(id);
        if(workPlanList == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(workPlanList));
    }
}
