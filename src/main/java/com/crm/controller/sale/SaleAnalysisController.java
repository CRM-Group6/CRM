package com.crm.controller.sale;

import com.crm.VO.SaleShow;
import com.crm.VO.ScatterData;
import com.crm.VO.chart.*;
import com.crm.deeplearning.predict.PredictionAPI;
import com.crm.entity.User;
import com.crm.service.sale.SaleAnalysisService;
import com.crm.service.sys.UserService;
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
    @Autowired
    private UserService userService;

    /**
     * 业绩统计：按照部门来分
     */
    @GetMapping("/performance/department")
    public ModelAndView findByDepartment(){
        List<ScatterData> list = new ArrayList<>();
        List<SaleShow> saleShowList = saleAnalysisService.findByDepartment();
        ScatterData scatterData1 = new ScatterData("销售部门",saleShowList.get(0).getNum());
        ScatterData scatterData2 = new ScatterData("财务部门",saleShowList.get(1).getNum());
        ScatterData scatterData3 = new ScatterData("客服部门",saleShowList.get(2).getNum());
        ScatterData scatterData4 = new ScatterData("业务部门",saleShowList.get(3).getNum());
        list.add(scatterData1);list.add(scatterData2);list.add(scatterData3);list.add(scatterData4);

        ChartVO chartVO = new ChartVO();
        Histogram histogram = new Histogram("部门业绩统计",list);
        List<Histogram> histogramsList = new ArrayList<>();
        histogramsList.add(histogram);
        chartVO.setCharts(histogramsList);
//        chartVO.setTitle(new Title("直方图"));
        ModelAndView model = new ModelAndView("/sale/saleAmount_analysis_chart");
        model.addObject("result",chartVO);
        return model;
    }

    /**
     * 业绩统计：按人员来分
     */
    @GetMapping("/performance/worker")
    public ModelAndView findByWorker(){
        List<ScatterData> list = new ArrayList<>();
        List<SaleShow> saleShowList = saleAnalysisService.findByWorker();
        for(int i = 0 ; i < saleShowList.size() ; i++){
            int id = saleShowList.get(i).getId();
            User user = userService.findOne(id);
            ScatterData scatterData = new ScatterData(user.getUsername(),saleShowList.get(i).getNum());
            list.add(scatterData);
        }

        ChartVO chartVO = new ChartVO();
        Histogram histogram = new Histogram("人员业绩统计",list);
        List<Histogram> histogramsList = new ArrayList<>();
        histogramsList.add(histogram);
        chartVO.setCharts(histogramsList);
//        chartVO.setTitle(new Title("直方图"));
        ModelAndView model = new ModelAndView("/sale/saleAmount_analysis_chart");
        model.addObject("result",chartVO);
        return model;
    }

    /**
     * 机会统计：根据部门来分
     */
    @GetMapping("/opportunity/department")
    public ModelAndView findByDepartmentOpportunity(){
        List<ScatterData> list = new ArrayList<>();
        List<SaleShow> saleShowList = saleAnalysisService.findByDepartmentOpportunity();
        ScatterData scatterData1 = new ScatterData("销售部门",saleShowList.get(0).getNum());
        ScatterData scatterData2 = new ScatterData("财务部门",saleShowList.get(1).getNum());
        ScatterData scatterData3 = new ScatterData("客服部门",saleShowList.get(2).getNum());
        ScatterData scatterData4 = new ScatterData("业务部门",saleShowList.get(3).getNum());
        list.add(scatterData1);list.add(scatterData2);list.add(scatterData3);list.add(scatterData4);

        ChartVO chartVO = new ChartVO();
        Histogram histogram = new Histogram("部门销售机会统计",list);
        List<Histogram> histogramsList = new ArrayList<>();
        histogramsList.add(histogram);
        chartVO.setCharts(histogramsList);
        ModelAndView model = new ModelAndView("/sale/opportunity_analysis_chart");
        model.addObject("result",chartVO);
        return model;
    }

    /**
     * 机会统计：根据人员来分
     */
    @GetMapping("/opportunity/worker")
    public ModelAndView findByWorkerOpportunity(){
        List<ScatterData> list = new ArrayList<>();
        List<SaleShow> saleShowList = saleAnalysisService.findByWorkerOpportunity();
        for(int i = 0 ; i < saleShowList.size() ; i++){
            int id = saleShowList.get(i).getId();
            User user1 = userService.findOne(id);
            ScatterData scatterData = new ScatterData(user1.getUsername(),saleShowList.get(i).getNum());
            list.add(scatterData);
        }

        ChartVO chartVO = new ChartVO();
        Histogram histogram = new Histogram("人员销售机会统计",list);
        List<Histogram> histogramsList = new ArrayList<>();
        histogramsList.add(histogram);
        chartVO.setCharts(histogramsList);
        ModelAndView model = new ModelAndView("/sale/opportunity_analysis_chart");
        model.addObject("result",chartVO);
        return model;
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

//    //测试
//    @GetMapping("/partment/analysis")
//    public ModelAndView analysis(){
//        List<ScatterData> list = new ArrayList<>();
//        for(int i=0;i<=3;i++){
//            ScatterData scatterData = new ScatterData(String.valueOf(i),i);
//            list.add(scatterData);
//        }
//        ChartVO chartVO = new ChartVO();
//        Histogram histogram = new Histogram("分析",list);
//        List<Histogram> histogramsList = new ArrayList<>();
//        histogramsList.add(histogram);
//        chartVO.setCharts(histogramsList);
//        chartVO.setTitle(new Title("直方图"));
//
//        ModelAndView model = new ModelAndView("/sale/sale_analysis_chart");
//        model.addObject("result",chartVO);
//        return model;
//    }
}
