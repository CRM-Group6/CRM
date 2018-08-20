package com.crm.service.sale;

import com.crm.VO.SaleShow;
import com.crm.mapper.sale.SalesRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售分析：业绩统计,机会统计
 * Created by JackKo
 * 2018/8/9 20:36
 **/
@Service
public class SaleAnalysisService {

    @Autowired
    private SalesRecordsMapper salesRecordsMapper;

    /**
     * 业绩统计：按照部门来分
     */
    public List<SaleShow> findByDepartment(){
        return salesRecordsMapper.findByDepartment();
    }

    /**
     * 业绩统计：按人员来分
     */
    public List<SaleShow> findByWorker(){
        return salesRecordsMapper.findByWorker();
    }

    /**
     * 机会统计：根据部门来分
     */
    public List<SaleShow> findByDepartmentOpportunity(){
        return salesRecordsMapper.findByDepartmentOpportunity();
    }

    /**
     * 机会统计：根据人员来分
     */
    public List<SaleShow> findByWorkerOpportunity(){
        return salesRecordsMapper.findByWorkerOpportunity();
    }

}
