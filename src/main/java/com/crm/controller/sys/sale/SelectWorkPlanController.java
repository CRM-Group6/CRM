package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.WorkPlan;
import com.crm.service.sale.WorkPlanService;
import com.crm.utils.ResultVOUtil;
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

    @GetMapping("/see/{id}")
    public ResultVO seeWorkPlan(@PathVariable("id") Long id){

        WorkPlan workPlanList = workPlanService.findOne(id);
        if(workPlanList == null) return ResultVOUtil.error();
        return ResultVOUtil.success(workPlanList);
    }

}
