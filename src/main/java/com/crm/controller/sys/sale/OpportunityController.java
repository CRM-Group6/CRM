package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.Opportunity;
import com.crm.service.sale.OpportunityService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 销售机会管理
 * Created by JackKo
 * 2018/8/13 10:30
 **/
@RestController
@RequestMapping("/sale/opportunityManage")
public class OpportunityController {

    @Autowired
    private OpportunityService opportunityService;

    //添加销售机会
    @PostMapping("/add")
    public ResultVO create(@RequestBody Opportunity opportunity){

        int res = opportunityService.addOpportunity(opportunity);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }


    //修改销售机会
    @PutMapping("/change")
    public ResultVO change(@RequestBody Opportunity opportunity){
        int res = opportunityService.changeOpportunity(opportunity);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }

    //查看销售机会
    @GetMapping("/see")
    public ResultVO findAll(){

        List<Opportunity> opportunityList = opportunityService.findAll();
        if(opportunityList == null) return ResultVOUtil.error();
        return ResultVOUtil.success(opportunityList);
    }

    //审核销售机会（查看，更改销售机会，更新字段）

    //分配销售机会（更改销售机会，更新字段）
}
