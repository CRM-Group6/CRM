package com.crm.mapper;

import com.crm.entity.Flight;

public interface FlightMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flight
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flight
     *
     * @mbggenerated
     */
    int insert(Flight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flight
     *
     * @mbggenerated
     */
    int insertSelective(Flight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flight
     *
     * @mbggenerated
     */
    Flight selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flight
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Flight record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flight
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Flight record);
}