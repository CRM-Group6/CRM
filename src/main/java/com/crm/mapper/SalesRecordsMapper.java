package com.crm.mapper;

import com.crm.entity.SalesRecords;

public interface SalesRecordsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_records
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_records
     *
     * @mbggenerated
     */
    int insert(SalesRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_records
     *
     * @mbggenerated
     */
    int insertSelective(SalesRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_records
     *
     * @mbggenerated
     */
    SalesRecords selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_records
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SalesRecords record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sales_records
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SalesRecords record);
}