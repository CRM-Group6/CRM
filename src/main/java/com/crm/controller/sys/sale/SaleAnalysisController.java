package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.SalesRecords;
import com.crm.service.sale.SaleAnalysisService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/findByDepartment")
    public ResultVO findByDepartment(){

        List<SalesRecords> salesRecords = saleAnalysisService.findByDepartment();
        if(salesRecords == null) return ResultVOUtil.error();
        return ResultVOUtil.success(salesRecords);
    }

    /**
     * 业绩统计：按人员来分
     */
    @GetMapping("/findByWorker")
    public ResultVO findByWorker(){

        List<SalesRecords> salesRecords = saleAnalysisService.findByWorker();
        if(salesRecords == null) return ResultVOUtil.error();
        return ResultVOUtil.success(salesRecords);
    }

    /**
     * 机会统计：根据部门来分
     */
    @GetMapping("/findByDepartmentOpportunity")
    public ResultVO findByDepartmentOpportunity(){

        List<SalesRecords> salesRecords = saleAnalysisService.findByDepartmentOpportunity();
        if(salesRecords == null) return ResultVOUtil.error();
        return ResultVOUtil.success(salesRecords);
    }

    /**
     * 机会统计：根据人员来分
     */
    @GetMapping("/findByWorkerOpportunity")
    public ResultVO findByWorkerOpportunity(){

        List<SalesRecords> salesRecords = saleAnalysisService.findByWorkerOpportunity();
        if(salesRecords == null) return ResultVOUtil.error();
        return ResultVOUtil.success(salesRecords);
    }

}
