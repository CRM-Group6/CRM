package com.crm.controller.custom_service;

import com.crm.VO.ResultVO;
import com.crm.entity.ComplainRecord;
import com.crm.entity.ProblemLibrary;
import com.crm.service.custom_service.ComplaintRecordService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/complain")
public class ComplainRecordController {
@Autowired
    private ComplaintRecordService complaintRecordService;
//    @GetMapping("console/customer_complaint")
//    public ResultVO findone(@RequestParam("id") Long id)
//    {       if(complaintRecordService.findone(id)==null){
//        return ResultVOUtil.error();
//    }
//    else
//        return ResultVOUtil.success( complaintRecordService.findone(id));
//    }

    @RequestMapping("/selectall")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("customer_complaint");
        model.addObject("complainRecords",complaintRecordService.selectAll());
        return model;
    }
    /*查询*/
    @RequestMapping("/findone")
    public ModelAndView find(@RequestParam(name = "id") Long id){
        ModelAndView model =new ModelAndView("customer_complaint");
        model.addObject("complainRecords",complaintRecordService.findone(id));
        return model;
    }
    /*修改update*/
    @RequestMapping("/edit")
    public ModelAndView edit(ComplainRecord complainRecord){
        complaintRecordService.updateone(complainRecord);
        return  new ModelAndView("redirect:/complain/selectall");
    }
    /*修改update跳转按钮*/
    @RequestMapping("/toedit")
    public ModelAndView toedit(Long id){
        ModelAndView model =new ModelAndView("/customer_complaint_edit");
        model.addObject("complainRecord",complaintRecordService.findone(id));
        return model;
    }
    /* 增加一条数据*/
    @RequestMapping("/add")
    public ModelAndView add(ComplainRecord complainRecord){

        complaintRecordService.addone(complainRecord);
        return  new ModelAndView("redirect:/complain/selectall");

    }
    /*增加一条记录跳转按钮*/
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //System.out.println("TOADD");
        return  new ModelAndView("/customer_complaint_add");}

    /*删除一条数据*/

    @RequestMapping("/delete")
    public ModelAndView delete(Long id){
        complaintRecordService.deleteone(id);
        return new ModelAndView("redirect:/complain/selectall");
    }
}


