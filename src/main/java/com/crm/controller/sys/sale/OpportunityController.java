package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.Opportunity;
import com.crm.service.sale.OpportunityService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/add")
    public int create(Opportunity opportunity){
        return opportunityService.addOpportunity(opportunity);
    }


    //修改销售机会
    @GetMapping("/change")
    public int change(Opportunity opportunity){
        return opportunityService.changeOpportunity(opportunity);
    }

    //查看销售机会
    @GetMapping("/see")
    public ResultVO findAll(){

        return ResultVOUtil.success(opportunityService.findAll());
    }

    //审核销售机会（查看，更改销售机会，更新字段）

    //分配销售机会（更改销售机会，更新字段）
}
