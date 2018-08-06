package com.crm.mapper.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.crm.entity.sys.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 用户相关信息 Mapper 接口
 * </p>
 *
 * @author Tony
 * @since 2018-04-17
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {
    /**
     * 通过用户账号获取用户对象
     * @param account
     * @return
     */
    User selectByAccount(@Param("account") String account);

}
