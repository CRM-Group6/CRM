package com.crm.controller.custom_service;


import com.crm.VO.ResultVO;


import com.crm.entity.AfterServiceProject;
import com.crm.mapper.AfterServiceProjectMapper;
import com.crm.service.custom_service.AfterServiceProjectService;

import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/afterserviceproject")
public class AfterServiceProjectController {
@Autowired
    private AfterServiceProjectService afterServiceProjectService;
    @RequestMapping("/selectall")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("customer_project");
        model.addObject("afterServiceProjects",afterServiceProjectService.selectAll());
        return model;
    }
    /*查询*/
    @RequestMapping("/findone")
    public ModelAndView find(Long id){
        ModelAndView model =new ModelAndView("customer_project");
        model.addObject("id",afterServiceProjectService.findone(id));
        return model;
    }
    /*修改update*/
    @RequestMapping("/edit")
    public ModelAndView edit(AfterServiceProject afterServiceProject){
        afterServiceProjectService.updateone(afterServiceProject);
        return  new ModelAndView("redirect:/afterserviceproject/selectall");
    }
//    修改update跳转按钮
    @RequestMapping("/toedit")
    public ModelAndView toedit(Long id){
        ModelAndView model =new ModelAndView("/customer_project_edit");
        model.addObject("afterServiceProject",afterServiceProjectService.findone(id));
        return model;
    }
//     增加一条数据
    @RequestMapping("/add")
    public ModelAndView add(AfterServiceProject afterServiceSheet){

        afterServiceProjectService.addone(afterServiceSheet);
        return  new ModelAndView("redirect:/afterserviceproject/selectall");

    }
//    增加一条记录跳转按钮
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //System.out.println("TOADD");
        return  new ModelAndView("/customer_project_add");}

//    删除一条数据

    @RequestMapping("/delete")
    public ModelAndView delete(Long id){
        afterServiceProjectService.deleteone(id);
        return new ModelAndView("redirect:/afterserviceproject/selectall");
    }
}
