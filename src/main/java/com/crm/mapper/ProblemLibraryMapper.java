package com.crm.mapper;

import com.crm.entity.ProblemLibrary;

public interface ProblemLibraryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    int insert(ProblemLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    int insertSelective(ProblemLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    ProblemLibrary selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ProblemLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table problem_library
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ProblemLibrary record);
}