package com.crm.controller.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.WorkPlan;
import com.crm.service.sale.WorkPlanService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


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

    @GetMapping("/see")
    public ModelAndView seeWorkPlan(@RequestParam("account") String account){


        ModelAndView model = new ModelAndView("/sale/sales_reminding");
        WorkPlan workPlanList = workPlanService.findByAccount(account);
        if(workPlanList == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(workPlanList));
    }

}
