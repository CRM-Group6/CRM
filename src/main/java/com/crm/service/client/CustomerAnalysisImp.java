package com.crm.service.client;

import com.crm.VO.ShowSum;
import com.crm.entity.Customer;
import com.crm.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Ben wu
 * @Description: 客户分析模块的Service
 * @Date: Created in 11:04 2018/8/13
 * @Modify By:
 */
@Service
public class CustomerAnalysisImp implements CustomerAnalysis{
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<ShowSum> customerRegionAnalysis() {
        //寻找所有区域
        List<ShowSum> list = customerMapper.selectSumByValue("province,city,area");
        int index=-1;
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getMsg()==null){
                index = i;
            }
        }
        if(index!=-1)
            list.remove(index);
       return list;
    }

    @Override
    public List<ShowSum> customerSourceAnalysis() {
        List<ShowSum> list = customerMapper.selectSumByValue("source");
        int index=-1;
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getMsg()==null){
                index = i;
            }
        }
        if(index!=-1)
            list.remove(index);
        return list;
    }

    @Override
    public List<ShowSum> customerIndustryAnalysis() {
        List<ShowSum> list = customerMapper.selectSumByValue("vocation");
        int index=-1;
        for (int i=0;i<list.size();i++) {
            if (list.get(i).getMsg()==null){
                index = i;
            }
        }
        if(index!=-1)
            list.remove(index);
        return list;
    }
}
