package com.crm.service.sys.contract_service;

import com.crm.entity.Contract;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Quinn
 * @Title: ContractStatisticsServiceTest
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/99:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractStatisticsServiceTest {

    @Autowired
    ContractStatisticsService service;
//    @Test
//    public void statisticsByExecuteStatus() {
//
//        List<Contract> contractList =  service.statisticsByExexute(1);
//       //Assert.assertEquals(1,contractList);
//        System.out.println(contractList);
//        System.out.println(contractList.size());
//
//    }
//
//    @Test
//    public void statisticsByCategory() {
//        List<Contract> conteact = service.statisticsByCategory(1);
//        System.out.println(conteact);
//        System.out.println(conteact.size());
//
//
//    }
//
//    @Test
//    public void statisticsByClientId() {
//        List<Contract> conteact = service.statisticsByClientId(1);
//        System.out.println(conteact);
//        System.out.println(conteact.size());
//    }
//
//    @Test
//    public void statisticsByExexuteAndCategory() {
//        List<Contract> result = service.statisticsByExexuteAndCategory(1,1);
//        System.out.println(result);
//        System.out.println(result.size());
//    }

    @Test
    public void statisticsByCombination() {
        Contract contract = new Contract();
        //contract.setDeadline(2018-08-09);
        contract.setCategory(1);
        contract.setExecuteStatus(1);
        List<Contract> contractList = service.statisticsByCombination(contract);
        System.out.println(contractList);
    }
}