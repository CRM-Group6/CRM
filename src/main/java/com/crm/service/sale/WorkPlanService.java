package com.crm.service.sale;

import com.crm.entity.WorkPlan;
import com.crm.mapper.sale.WorkPlanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 客户工作计划管理
 * Created by JackKo
 * 2018/8/8 14:55
 **/
@Service
public class WorkPlanService {

    @Autowired
    private WorkPlanMapper workPlanMapper;

    /**
     * 新建（添加/保存）开发计划
     */
    public int addWorkPlan(WorkPlan workPlan){
        return workPlanMapper.insert(workPlan);
    }


    /**
     * 修改（更新）开发计划
     */
    public int changeWorkPlan(WorkPlan workPlan){
        return workPlanMapper.updateByPrimaryKey(workPlan);
    }

    /**
     * 删除开发计划
     */
    public int deleteWorkPlan(Long id){
        return workPlanMapper.deleteByPrimaryKey(id);
    }

    /**
     * 显示一个计划
     */
    public WorkPlan findOne(Long id){
        return workPlanMapper.selectByPrimaryKey(id);
    }
    /**
     * 显示一个计划
     */
    public List<WorkPlan> findByAccount(String account){
        return  workPlanMapper.selectByAccount(account);
    }
    /**
     * 显示所有的计划
     */
    public List<WorkPlan> findAll(){
        return workPlanMapper.selectAll();
    }
}
