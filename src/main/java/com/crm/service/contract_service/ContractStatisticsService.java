package com.crm.service.contract_service;

import com.crm.entity.Contract;
import com.crm.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Quinn
 * @Title: ContractStatisticsService
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/820:27
 */
@Service
public class ContractStatisticsService {

    @Autowired
    ContractMapper contractMapper;
    //根据合同时间查找
//    public List<Contract> statisticsByTime(Date time){
//        return contractMapper.selectByCreateTime(time);
//
//    }
//
//    //根据执行状态查找
//    public List<Contract> statisticsByExexute(int status){
//
//        return contractMapper.selectByExecuteStatus(status);
//    }
//
//    //根据合同类型查找
//    public List<Contract> statisticsByCategory(int category){
//        return contractMapper.selectByCategory(category);
//    }
//    //根据客户类型查找
//    List<Contract> statisticsByClientId(int category){
//        return contractMapper.selectByClientId(category);
//    }
//    List<Contract> statisticsByExexuteAndCategory(int status,int category){
//        return contractMapper.selectByStatusAndType(status, category);
//    }

    public int statisticsByCombination(Contract contract)
    {
        return contractMapper.selectByCombination(contract);
    }



}
