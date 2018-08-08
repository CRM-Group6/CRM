package com.crm.service.sys;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.crm.entity.User;
import com.crm.mapper.UserMapper;
import com.crm.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户相关信息 服务实现类
 * </p>
 *
 * @author Tony
 * @since 2018-04-17
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getByAccount(String account) {
        return userMapper.selectByAccount(account);
    }

}
