package com.crm.service.sys.contract_service;

import com.crm.entity.Contract;
import com.crm.mapper.ContractMapper;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Quinn
 * @Title: ContractService
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/814:50
 */
@Service
public class ContractService {
    @Autowired
    private ContractMapper contractMapper;

    /**
     * 创建合同，返回合同内容给前端
     * 使用者：销售经理、销售人员
     * @param contract
     * @return
     */
    public Contract insert(Contract contract){
        Integer result =  contractMapper.insert(contract);
        if(result == null) {
            return null;
        }
        else
        {
            return contract;
        }
    }

//    /**
//     * 删除合同
//     * @param id
//     */
//    public void deleteContract(Long id){
//        Integer result =  contractMapper.deleteByPrimaryKey(id);
//
//    }

    /**
     *项目经理审核合同,审核结果、审核状态
     * 使用者：销售经理
     * @param contract
     * @return
     */
    public Contract checkedContract(Contract contract){

        Integer result = contractMapper.updateByPrimaryKey(contract);
        Assert.assertNotNull(result);
        if(result != null)
            return contract;
        else
            return null;
    }

    /**
     * 查询合同，可以组合合同类型、收支类型、执行状态及客户信息
     * 和其他关键字查询合同相关内容信息。
     * @param id
     */
    public void  findContract(Long id){
        Contract contract = contractMapper.selectByPrimaryKey(id);
       // Assert.assertEquals(123,contract.getId().longValue());
    }

    //根据合同时间查找
    public List<Contract> statisticsByTime(Date time){
        return contractMapper.selectByCreateTime(time);

    }

    //根据执行状态查找
    public List<Contract> statisticsByExexute(int status){

        return contractMapper.selectByExecuteStatus(status);
    }
    //根据合同类型查找
    public List<Contract> statisticsByCategory(int category){
        return contractMapper.selectByCategory(category);
    }
    //根据客户类型查找
    List<Contract> statisticsByClientId(int category){
        return contractMapper.selectByClientId(category);
    }
    List<Contract> statisticsByExexuteAndCategory(int status,int category){
        return contractMapper.selectByStatusAndType(status, category);
    }





}
