package com.crm.controller.sale;

import com.crm.entity.Opportunity;
import com.crm.service.sale.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

//    //添加销售机会
//    @PostMapping("/add")
//    public ResultVO create(@RequestBody Opportunity opportunity){
//
//        int res = opportunityService.addOpportunity(opportunity);
//        if(res == 0) return ResultVOUtil.error();
//        return ResultVOUtil.success(res);
//    }
//
//
//    //修改销售机会
//    @PutMapping("/change")
//    public ResultVO change(@RequestBody Opportunity opportunity){
//        int res = opportunityService.changeOpportunity(opportunity);
//        if(res == 0) return ResultVOUtil.error();
//        return ResultVOUtil.success(res);
//    }
//
//    //查看销售机会
//    @GetMapping("/see")
//    public ResultVO findAll(){
//
//        List<Opportunity> opportunityList = opportunityService.findAll();
//        if(opportunityList == null) return ResultVOUtil.error();
//        return ResultVOUtil.success(opportunityList);
//    }
//
//    //审核销售机会（查看，更改销售机会，更新字段）
//
//    //分配销售机会（更改销售机会，更新字段）

    @RequestMapping("/selectall")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("/sale/sales_opportunity_management");
        model.addObject("opportunitys",opportunityService.findAll());
        return model;
    }
    /*查询*/
    @RequestMapping("/findone")
    public ModelAndView find(){
        ModelAndView model =new ModelAndView("/sale/sales_opportunity_management");
        model.addObject("id",opportunityService.findOne((long)11));
        return model;
    }

    /*修改update*/
    @RequestMapping("/edit")
    public ModelAndView edit(Opportunity opportunity){
        opportunityService.changeOpportunity(opportunity);
        return  new ModelAndView("redirect:/sale/opportunityManage/selectall");
    }
    /*修改update跳转按钮*/
    @RequestMapping("/toedit")
    public ModelAndView toedit(Long id){
        ModelAndView model =new ModelAndView("/sale/sales_opportunity_management_edit");
        model.addObject("opportunityManage",opportunityService.findOne(id));
        return model;
    }


    /*增加一条数据*/
    @RequestMapping("/add")
    public ModelAndView add(Opportunity opportunity){

        opportunityService.addOpportunity(opportunity);
//        System.out.println("I'm here");
        return  new ModelAndView("redirect:/sale/opportunityManage/selectall");
    }

    /*增加一条记录跳转按钮*/
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //System.out.println("TOADD");
        return  new ModelAndView("/sale/sales_opportunity_management_add");}


    /*删除一条数据*/
    @RequestMapping("/delete")
    public ModelAndView delete(Long id){
        opportunityService.deleteOpportunity(id);
        return new ModelAndView("redirect:/sale/opportunityManage/selectall");
    }
}
