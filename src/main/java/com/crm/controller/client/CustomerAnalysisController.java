package com.crm.controller.client;

import com.crm.VO.ShowSum;
import com.crm.entity.Customer;
import com.crm.service.client.CustomerAnalysis;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 15:26 2018/8/14
 * @Modify By:
 */
@RestController
@RequestMapping("/analysis")
public class CustomerAnalysisController {
    @Autowired
    private CustomerAnalysis customerAnalysis;
    //区域
    @GetMapping(value = "/region")
    private ModelAndView customerRegionAnalysis(){
        List<ShowSum> list = customerAnalysis.customerRegionAnalysis();
        ModelAndView model= new ModelAndView("/client/customer_analysis");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(list));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
    //来源
    @GetMapping(value = "/source")
    private ModelAndView customerSourceAnalysis(){
        List<ShowSum> list = customerAnalysis.customerSourceAnalysis();
        ModelAndView model= new ModelAndView("/client/customer_analysis");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(list));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
    //行业
    @GetMapping(value = "/industry")
    private ModelAndView customerIndustryAnalysis(){
        List<ShowSum> list = customerAnalysis.customerIndustryAnalysis();
        ModelAndView model= new ModelAndView("/client/customer_analysis");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(list));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
}
