package com.crm.controller.custom_service;


import com.crm.VO.ResultVO;
import com.crm.entity.AfterServiceSheet;
import com.crm.entity.ProblemLibrary;
import com.crm.service.custom_service.AfterServiceSheetService;
import com.crm.utils.ResultVOUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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


   /* @RequestMapping("/user")
    public ModelAndView index( @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "3") Integer pageSize) {
        PageInfo<AfterServiceSheet> pageInfo = afterServiceSheetService.findAll(pageNum, pageSize);
        ModelAndView model =new ModelAndView("maintain");
        //获得当前页
        model.addObject("pageNum", pageInfo.getPageNum());
        //获得一页显示的条数
        model.addObject("pageSize", pageInfo.getPageSize());
        //是否是第一页
        model.addObject("isFirstPage", pageInfo.isIsFirstPage());
        //获得总页数
        model.addObject("totalPages", pageInfo.getPages());
        //是否是最后一页
        model.addObject("isLastPage", pageInfo.isIsLastPage());
        model.addObject("afterServiceSheets", pageInfo.getList());
        return model;
    }*/
}
