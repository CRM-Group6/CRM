package com.crm.mapper;

import com.crm.entity.Info;
import com.crm.enums.InfoType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "infoMapper")
public interface InfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated
     */
    int insert(Info record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated
     */
    int insertSelective(Info record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated
     */
    Info selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Info record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Info record);

    /**
     * 此方法用于返回咨询信息
     * @param infoType
     * @return List<Info>
     */
    List<Info> selectInfoByUserID(@Param("infoType")int infoType);
}