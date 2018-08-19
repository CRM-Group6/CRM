package com.crm.mapper.sale;

import com.crm.entity.WorkPlan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "workPlanMapper")
public interface WorkPlanMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    int insert(WorkPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    int insertSelective(WorkPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    WorkPlan selectByPrimaryKey(Long id);
    List<WorkPlan> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(WorkPlan record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table work_plan
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(WorkPlan record);
    WorkPlan selectByAccount(String account);
}