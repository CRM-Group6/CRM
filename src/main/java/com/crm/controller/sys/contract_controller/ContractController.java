package com.crm.controller.sys.contract_controller;

import com.crm.VO.ResultVO;
import com.crm.entity.Contract;
import com.crm.service.sys.contract_service.ContractService;
import com.crm.service.sys.contract_service.ContractStatisticsService;
import com.crm.utils.ResultVOUtil;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Quinn
 * @Title: ContractController
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/916:49
 */
@RestController
@RequestMapping(value = "/contract")
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractStatisticsService service;

    @GetMapping(value = "/list")
    //组合查询&查询
    public ResultVO list(Contract contract){
        List<Contract> contractList = contractService.statisticsByCombination(contract);
        System.out.println(contractList);
        return ResultVOUtil.success(contractList);

    }
    //插入合同
    @RequestMapping(value = "/insert")
    public ResultVO insert(Contract contract){
          Contract contract1 = contractService.insert(contract);

        return ResultVOUtil.success(contract1);
    }
    //审核合同


    @RequestMapping(value = "/statistics")
    //统计合同数量
    public  ResultVO Tonji(Contract contract){
        int i = 0;
        List<Contract> result =  service.statisticsByCombination(contract);
        for(Contract contract1:result){
            i++;
        }
        return ResultVOUtil.success(i);
    }





}
