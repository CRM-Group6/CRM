package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.VO.chart.Axis;
import com.crm.VO.chart.ChartVO;
import com.crm.VO.chart.Title;
import com.crm.VO.chart.ToolTip;
import com.crm.deeplearning.predict.PredictionAPI;
import com.crm.entity.SalesRecords;
import com.crm.service.sale.SaleAnalysisService;
import com.crm.utils.ResultVOUtil;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 销售分析：业绩统计，机会统计
 * Created by JackKo
 * 2018/8/13 10:33
 **/
@RestController
@RequestMapping("/sale/saleAnalysis")
public class SaleAnalysisController {

    @Autowired
    private SaleAnalysisService saleAnalysisService;

    /**
     * 业绩统计：按照部门来分
     */
    @GetMapping("/performance/department")
    public ModelAndView findByDepartment(){
        ModelAndView model = new ModelAndView("/sale/sale_analysis");
        model.addObject("category","performance");
        model.addObject("name","业绩统计");
        model.addObject("type","department");
        List<SaleShow> salesRecords = saleAnalysisService.findByDepartment();
        if(salesRecords == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(salesRecords));
    }

    /**
     * 业绩统计：按人员来分
     */
    @GetMapping("/performance/worker")
    public ModelAndView findByWorker(){
        ModelAndView model = new ModelAndView("/sale/sale_analysis");
        model.addObject("category","performance");
        model.addObject("name","业绩统计");
        model.addObject("type","worker");
        List<SaleShow> salesRecords = saleAnalysisService.findByWorker();
        if(salesRecords == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(salesRecords));
    }

    /**
     * 机会统计：根据部门来分
     */
    @GetMapping("/chance/department")
    public ModelAndView findByDepartmentOpportunity(){
        ModelAndView model = new ModelAndView("/sale/sale_analysis");
        model.addObject("category","chance");
        model.addObject("name","机会统计");
        model.addObject("type","department");
        List<SaleShow> salesRecords = saleAnalysisService.findByDepartmentOpportunity();
        if(salesRecords == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(salesRecords));
    }

    /**
     * 机会统计：根据人员来分
     */
    @GetMapping("/chance/worker")
    public ModelAndView findByWorkerOpportunity(){
        ModelAndView model = new ModelAndView("/sale/sale_analysis");
        model.addObject("category","chance");
        model.addObject("name","机会统计");
        model.addObject("type","worker");
        List<SaleShow> salesRecords = saleAnalysisService.findByWorkerOpportunity();
        if(salesRecords == null) return model.addObject("result",ResultVOUtil.error());
        return model.addObject("result",ResultVOUtil.success(salesRecords));
    }

    /**
     * 销售额预测
     * @return
     */
    @RequestMapping("/prediction")
    public ModelAndView prediction(){
        ChartVO chartVO = new ChartVO();

        try {
            chartVO.setCharts(PredictionAPI.predictionUI());
            Title title = new Title("销售额预测");
            chartVO.setTitle(title);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKerasConfigurationException e) {
            e.printStackTrace();
        } catch (UnsupportedKerasConfigurationException e) {
            e.printStackTrace();
        }
        //设置x轴
        Axis axis = new Axis();
        axis.setTitle(new Title("天数"));
        axis.setCategories(new ArrayList<>());
        for(int i=0;i<chartVO.getCharts().size();i++){
            axis.getCategories().add(String.valueOf(i));
        }
        chartVO.setAxis(axis);
        Axis yaxis = new Axis();
        yaxis.setTitle(new Title("销售额"));
        chartVO.setYAxis(yaxis);
        ToolTip tooltip=new ToolTip();
        chartVO.setToolTip(tooltip);
        ModelAndView model = new ModelAndView("/sale/predictchart");
        model.addObject("result",chartVO);
        model.addObject("prediction" , PredictionAPI.newestPredict());
        return model;
    }
}
