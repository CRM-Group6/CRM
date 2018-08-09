package com.crm.service.sale;

import com.crm.entity.CustomerStatistics;
import com.crm.mapper.sale.CustomerStatisticsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售分析：客户统计
 * Created by JackKo
 * 2018/8/9 21:15
 **/
@Service
public class CustomerAnalyService {

    @Autowired
    private CustomerStatisticsMapper customerStatisticsMapper;

    /**
     * 客户统计：读取各信息
     */
    public List<CustomerStatistics> findAll(){
        return customerStatisticsMapper.selectAll();
    }

}
