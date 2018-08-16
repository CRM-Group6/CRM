package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.CustomerStatistics;
import com.crm.service.sale.CustomerAnalysisService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 销售分析：客户统计
 * Created by JackKo
 * 2018/8/13 10:32
 **/
@RestController
@RequestMapping("/sale/customerAnalysis")
public class CustomerAnalysisController {

    @Autowired
    private CustomerAnalysisService customerAnalysisService;

    //查看统计
    @GetMapping("/see")
    public ModelAndView findAll(){
        List<CustomerStatistics> customerStatisticsList = customerAnalysisService.findAll();
        ModelAndView model=new ModelAndView("/sale/customerAnalysis");
        if(customerStatisticsList == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(customerStatisticsList));
    }
}
