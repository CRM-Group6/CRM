package com.crm.mapper;

import com.crm.VO.ShowContractVO;
import com.crm.VO.ShowSum;
import com.crm.entity.Contract;
import com.crm.entity.ContractStatistic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Mapper
@Component(value = "contractMapper")
public interface ContractMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract
     *
     * @mbggenerated
     */
    int insert(Contract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract
     *
     * @mbggenerated
     */
    int insertSelective(Contract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract
     *
     * @mbggenerated
     */
    Contract selectByPrimaryKey(Long id);
    Contract update(Long id);
    List<ShowContractVO> selectByValue(@Param("value")String value);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Contract record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table contract
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Contract record);
    List<Contract> findAll(Pageable pageable);
    //查询
    int selectByCombination(Contract contract);
    List<Contract> select(Contract contract);
//    //根据合同时间查找
//    List<Contract> selectByCreateTime(Date createTime);


//    //根据机型状态和合同类型查询（传入多个参数时不确定那个参数时哪个，所以要加@Param）
//    List<Contract> selectByStatusAndType(@Param("executeStatus") int status, @Param("category")int category);
    /**
     * 根据执行状态寻找，返回数量
     //* @param status
     * @return
     */
//    List<Contract> selectByExecuteStatus(int status);
//
//    //根据合同类型寻找，返回数量
//    List<Contract> selectByCategory(int category);

    //根据客户类型寻找，返回数量
    List<Contract> selectByClientId(int catrgory);
    Contract findById(Long id);

    List<ContractStatistic> selectByDate(String year, Integer type);

}