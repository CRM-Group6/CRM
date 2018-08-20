package com.crm.controller.client;

import com.crm.VO.ShowSum;
import com.crm.VO.chart.Chart;
import com.crm.VO.chart.ChartVO;
import com.crm.VO.chart.Pie;
import com.crm.VO.chart.PieItem;
import com.crm.entity.Customer;
import com.crm.service.client.CustomerAnalysis;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
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
        List<PieItem> dataList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            PieItem pieItem = new PieItem(list.get(i).getMsg(),list.get(i).getNum());
            dataList.add(pieItem);
        }
        Pie chart = new Pie("区域分析饼图",dataList);
        chart.setType("pie");
        List<Pie> charts = new ArrayList<>();
        charts.add(chart);
        ChartVO chartVO = new ChartVO(charts,null,null,null,"区域分析");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(chartVO));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
    //来源
    @GetMapping(value = "/source")
    private ModelAndView customerSourceAnalysis(){
        List<ShowSum> list = customerAnalysis.customerSourceAnalysis();
        ModelAndView model= new ModelAndView("/client/customer_analysis");
        List<PieItem> dataList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            PieItem pieItem = new PieItem(list.get(i).getMsg(),list.get(i).getNum());
            dataList.add(pieItem);
        }
        Pie chart = new Pie("来源分析饼图",dataList);
        chart.setType("pie");
        List<Pie> charts = new ArrayList<>();
        charts.add(chart);
        ChartVO chartVO = new ChartVO(charts,null,null,null,"来源分析");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(chartVO));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
    //行业
    @GetMapping(value = "/industry")
    private ModelAndView customerIndustryAnalysis(){
        List<ShowSum> list = customerAnalysis.customerIndustryAnalysis();
        ModelAndView model= new ModelAndView("/client/customer_analysis");
        List<PieItem> dataList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            PieItem pieItem = new PieItem(list.get(i).getMsg(),list.get(i).getNum());
            dataList.add(pieItem);
        }
        Pie chart = new Pie("行业分析饼图",dataList);
        chart.setType("pie");
        List<Pie> charts = new ArrayList<>();
        charts.add(chart);
        ChartVO chartVO = new ChartVO(charts,null,null,null,"行业分析");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(chartVO));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
}
