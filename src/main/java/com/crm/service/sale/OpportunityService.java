package com.crm.service.sale;

import com.crm.entity.Opportunity;
import com.crm.mapper.sale.OpportunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售机会管理
 * Created by JackKo
 * 2018/8/8 14:54
 **/
@Service
public class OpportunityService {

    @Autowired
    private OpportunityMapper opportunityMapper;

    /**
     * 添加(保存)销售机会
     */
    public int addOpportunity(Opportunity opportunity){
        return  opportunityMapper.insert(opportunity);
    }

    /**
     * 修改销售机会
     */
    public int changeOpportunity(Opportunity opportunity){
        return opportunityMapper.updateByPrimaryKey(opportunity);
    }

    /**
     * 删除某个销售机会
     */
    public int deleteOpportunity(Long id){
        return opportunityMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查看某个销售机会
     */
    public Opportunity findOne(Long id){
        return opportunityMapper.selectByPrimaryKey(id);
    }


    /**
     * 查看所有销售机会
     */
    public List<Opportunity> findAll(){
        return opportunityMapper.findAll();
    }




}
