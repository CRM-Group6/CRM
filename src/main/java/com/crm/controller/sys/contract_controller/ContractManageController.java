package com.crm.controller.sys.contract_controller;

import com.crm.service.sys.contract_service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Quinn
 * @Title: ContractInsertController
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/815:15
 */
@RequestMapping(value = "/contract")
@Controller
public class ContractManageController {
    @Autowired
    private ContractService contractService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public  void insertContract(){


    }


}
