package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.Contact;
import com.crm.entity.ExchangeInfo;
import com.crm.service.sale.ExchangeInfoService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 交往信息
 * Created by JackKo
 * 2018/8/13 10:33
 **/
@RestController
@RequestMapping("/sale/exchangeInfo")

public class ExchangeManageController {

    @Autowired
    private ExchangeInfoService exchangeInfoService;

//    //增加交往信息
//    @PostMapping("/add")
//    public ResultVO create(@RequestBody ExchangeInfo exchangeInfo){
//
//        int res = exchangeInfoService.addExchangeInfo(exchangeInfo);
//        if(res == 0) return ResultVOUtil.error();
//        return ResultVOUtil.success(res);
//    }
//
//
//    //修改交往信息
//    @PutMapping("/change")
//    public ResultVO change(@RequestBody ExchangeInfo exchangeInfo){
//
//        int res = exchangeInfoService.changeExchangeInfo(exchangeInfo);
//        if(res == 0) return ResultVOUtil.error();
//        return ResultVOUtil.success(res);
//    }
//
//
//    //删除交往信息
//    @DeleteMapping("/delete/{id}")
//    public ResultVO delete(@PathVariable Long id){
//
//        int res = exchangeInfoService.deleteExchangeInfo(id);
//        if(res == 0) return ResultVOUtil.error();
//        return ResultVOUtil.success(res);
//    }
//
//    //查看所有交往信息
//    @GetMapping("/see")
//    public ResultVO seeAll(){
//
//        List<ExchangeInfo> exchangeInfoList = exchangeInfoService.findAll();
//        if(exchangeInfoList == null) return ResultVOUtil.error();
//        return ResultVOUtil.success(exchangeInfoList);
//    }
//
//    //查看单个交往信息
//    @GetMapping("/see/{id}")
//    public ResultVO seeOne(@PathVariable Long id){
//
//        ExchangeInfo exchangeInfoList = exchangeInfoService.findOne(id);
//        if(exchangeInfoList == null) return ResultVOUtil.error();
//        return ResultVOUtil.success(exchangeInfoList);
//
//    }

    @RequestMapping("/selectall")
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("/sale/exchange_management");
        model.addObject("exchangeInfos",exchangeInfoService.findAll());
        return model;
    }
    /*查询*/
    @RequestMapping("/findone")
    public ModelAndView find(){
        ModelAndView model =new ModelAndView("/sale/exchange_management");
        model.addObject("id",exchangeInfoService.findOne((long)11));
        return model;
    }

    /*增加一条数据*/
    @RequestMapping("/add")
    public ModelAndView add(ExchangeInfo exchangeInfo){

        exchangeInfoService.addExchangeInfo(exchangeInfo);
        System.out.println("I'm here");
        return  new ModelAndView("redirect:/sale/exchangeInfo/selectall");
    }

    /*增加一条记录跳转按钮*/
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        //System.out.println("TOADD");
        return  new ModelAndView("/sale/exchange_management_add");}


    /*删除一条数据*/
    @RequestMapping("/delete")
    public ModelAndView delete(Long id){
        exchangeInfoService.deleteExchangeInfo(id);
        return new ModelAndView("redirect:/sale/exchangeInfo/selectall");
    }

}
