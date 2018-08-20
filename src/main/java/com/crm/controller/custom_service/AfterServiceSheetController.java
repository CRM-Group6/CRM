package com.crm.controller.custom_service;


import com.crm.VO.ResultVO;
import com.crm.entity.AfterServiceSheet;
import com.crm.entity.ProblemLibrary;
import com.crm.service.custom_service.AfterServiceSheetService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/afterservicesheet")
public class AfterServiceSheetController {
    @Autowired
    private AfterServiceSheetService afterServiceSheetService;

    @RequestMapping("/selectall")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("maintain");
        model.addObject("afterServiceSheets",afterServiceSheetService.selectAll());
        return model;
    }
    /*查询*/
    @RequestMapping("/findone")
    public ModelAndView find(Long id){
        ModelAndView model =new ModelAndView("maintain");
        model.addObject("afterServiceSheets",afterServiceSheetService.findone(id));
        return model;
    }
    /*修改update*/
    @RequestMapping("/edit")
    public ModelAndView edit(AfterServiceSheet afterServiceSheet){
        afterServiceSheetService.updateone(afterServiceSheet);
        return  new ModelAndView("redirect:/afterservicesheet/selectall");
    }
    /*修改update跳转按钮*/
    @RequestMapping("/toedit")
    public ModelAndView toedit(Long id){
        ModelAndView model =new ModelAndView("/maintain_edit");
        model.addObject("afterServiceSheet",afterServiceSheetService.findone(id));
        return model;
    }
    /* 增加一条数据*/
    @RequestMapping("/add")
    public ModelAndView add(AfterServiceSheet afterServiceSheet){

        afterServiceSheetService.addone(afterServiceSheet);
        return  new ModelAndView("redirect:/afterservicesheet/selectall");

    }
    /*增加一条记录跳转按钮*/
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //System.out.println("TOADD");
        return  new ModelAndView("/maintain_add");}

    /*删除一条数据*/

    @RequestMapping("/delete")
    public ModelAndView delete(Long id){
        afterServiceSheetService.deleteone(id);
        return new ModelAndView("redirect:/afterservicesheet/selectall");
    }
}
