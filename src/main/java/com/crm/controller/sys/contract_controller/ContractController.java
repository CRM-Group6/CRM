package com.crm.controller.sys.contract_controller;

import com.crm.VO.ResultVO;
import com.crm.entity.Contract;
import com.crm.entity.Customer;
import com.crm.enums.verify_enum.VerifyTypeEnum;
import com.crm.service.sys.contract_service.ContractService;
import com.crm.service.sys.contract_service.ContractStatisticsService;
import com.crm.utils.ResultVOUtil;
import org.junit.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
        PageRequest request = new PageRequest(0,2);
        List<Contract> contractList = contractService.statisticsByCombination(contract);
        System.out.println(contractList);
        return ResultVOUtil.success(contractList);

    }
    //插入合同
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResultVO insert( Contract contract){
          ResultVO result= new ResultVO();
          Contract contract1 = new Contract();
          Customer customer = new Customer();
//          if(contract.getId()==null) throw Exception{
//            result.setMsg("合同ID不能为空");
//        }判断字段是否为空

          contract1.setId(contract.getId());
         //添加一个匹配顾客是否存在的判断
          contract1.setClientId(contract.getClientId());
        //以下内容为必填
          contract1.setSalesmanId(contract.getSalesmanId());
          contract1.setVerifyStatus(contract.getVerifyStatus());
          contract1.setVerifyOpinion(contract.getVerifyOpinion());
          contract1.setCategory(contract.getCategory());
          contract1.setMoney(contract.getMoney());
          contract1.setExecuteStatus(contract.getExecuteStatus());

          contract1.setDetails(contract.getDetails());
          Contract a= contractService.insert(contract1);

//            return  "redict:/mian";
        return  ResultVOUtil.success(a);
    }
    //审核合同
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResultVO check(Contract contract){
        Contract contract1 = new Contract();
        contract1 = contractService.findById(contract.getId());
        contract1.setVerifyStatus(contract.getVerifyStatus());
        contractService.checkedContract(contract1);
        return ResultVOUtil.success(contract1);
    }

    @RequestMapping(path = "/statistics")
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
