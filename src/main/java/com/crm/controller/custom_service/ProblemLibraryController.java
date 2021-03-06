package com.crm.controller.custom_service;

import com.crm.VO.ResultVO;
import com.crm.entity.ProblemLibrary;
import com.crm.service.custom_service.ProblemLibraryService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/problem")
public class ProblemLibraryController {
    @Autowired
    private ProblemLibraryService problemLibraryService;
  /* @GetMapping("console/financial_management")
    public ResultVO findone(@RequestParam("selectrequest") Long id)
    {       if(problemLibraryService.findone(id)==null){
        return ResultVOUtil.error();
        }
        else
            return ResultVOUtil.success( problemLibraryService.findone(id));
    }*/
    /*@GetMapping("console/financial_management_add")
   public ResultVO addone(@RequestParam("obj") ProblemLibrary problemLibrary){
        if(problemLibraryService.addone(problemLibrary)==1){

        }
        return null;
    }
*/

    /*显示全表*/
    @RequestMapping("/selectall")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("service_support");
        model.addObject("problems",problemLibraryService.selectAll());
        return model;
    }
    /*查询*/
    @RequestMapping("/findone")
    public ModelAndView find(Long id){
        ModelAndView model =new ModelAndView("service_support");
        model.addObject("problems",problemLibraryService.findone(id));
        return model;
    }
    /*修改update*/
    @RequestMapping("/edit")
    public ModelAndView edit(ProblemLibrary problemLibrary){
      problemLibraryService.updateone(problemLibrary);
      return  new ModelAndView("redirect:/problem/selectall");
    }
    /*修改update跳转按钮*/
    @RequestMapping("/toedit")
    public ModelAndView toedit(Long id){
        ModelAndView model =new ModelAndView("/service_support_edit");
        model.addObject("problem",problemLibraryService.findone(id));
        return model;
    }
   /* 增加一条数据*/
    @RequestMapping("/add")
    public ModelAndView add(ProblemLibrary problemLibrary){

       problemLibraryService.addone(problemLibrary);
        return  new ModelAndView("redirect:/problem/selectall");

    }
    /*增加一条记录跳转按钮*/
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //System.out.println("TOADD");
        return  new ModelAndView("/service_support_add");}

    /*删除一条数据*/

    @RequestMapping("/delete")
    public ModelAndView delete(Long id){

        problemLibraryService.deleteone(id);
        return new ModelAndView("redirect:/problem/selectall");
    }

}
