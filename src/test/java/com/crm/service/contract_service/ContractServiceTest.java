package com.crm.service.contract_service;

import com.crm.entity.Contract;
import com.crm.enums.verify_enum.VerifyTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Quinn
 * @Title: ContractServiceTest
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/815:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractServiceTest {

    @Autowired
    ContractService contractService;

    @Test
    public void insert() {
//        Contract contract = new Contract();
//        contract.setId((long) 123456);
//        contract.setClientId((long)123);
//        contract.setSalesmanId((long) 12345678);
//        contract.setVerifyStatus(VerifyTypeEnum.CHECKED.getCode());
//        Contract result = contractService.insert(contract);
//        Assert.assertNotNull(result);
    }

    @Test
    public void findContract() {
    }

    @Test
    public void deleteContract() {
    }


    @Test
    public void statisticsByCombination() {
//        Contract contract = new Contract();
//
//        contract.setVerifyOpinion("2");
//        List<Contract> contractList =  contractService.statisticsByCombination(contract);
//        for (Contract contract1:contractList){
//            System.out.println(contract1);
//        }
//
//        System.out.println(contractList.size());
//    }
    }
}