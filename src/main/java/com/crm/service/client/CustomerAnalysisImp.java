package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.entity.Region;
import com.crm.entity.ShowList;
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
    public List<ShowList<Customer,Region>> customerRegionAnalysis() {
        //寻找所有区域
        List<ShowList<Customer,Region>> list = new ArrayList<>();
        List<Region> regionList = findAllPossibleRegion();
        for(int i=0 ;i<regionList.size();i++){
            //按照区域寻找所有客户
            List<Customer> userList = findAllCustomerByRegion(regionList.get(i));
            //添加新列表
            ShowList<Customer,Region> showList = new ShowList<>(regionList.get(i),userList);
            list.add(showList);
        }
        //返回列表
        return list;
    }

    @Override
    public List<ShowList<Customer,String>> customerSourceAnalysis() {
        List<String> valueList = customerMapper.selectAllPossibleValue("source");
        System.out.println(valueList);
        List<ShowList<Customer,String>> list = new ArrayList<>();
        for(int i=0;i<valueList.size();i++){
            //寻找对应source值的所有用户
            List<Customer> customers = customerMapper.selectAllCustomerByValue("source",valueList.get(i));
            ShowList<Customer,String> showList = new ShowList<>("source",customers);
            list.add(showList);
        }
        return list;
    }

    @Override
    public List<ShowList<Customer,String>> customerIndustryAnalysis() {
        List<String> valueList = customerMapper.selectAllPossibleValue("vocation");
        System.out.println(valueList);
        List<ShowList<Customer,String>> list = new ArrayList<>();
        for(int i=0;i<valueList.size();i++){
            //寻找对应vocation值的所有用户
            List<Customer> customers = customerMapper.selectAllCustomerByValue("vocation",valueList.get(i));
            ShowList<Customer,String> showList = new ShowList<>("vocation",customers);
            list.add(showList);
        }
        return list;
    }

    @Override
    public List<Region> findAllPossibleRegion() {
        return customerMapper.selectAllCustomerRegion();
    }

    @Override
    public List<Customer> findAllCustomerByRegion(Region region) {
        return customerMapper.selectAllCustomerByRegion(region);
    }
}
