package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Ben wu
 * @Date 2018/8/9
 * @Description 用于客户分配用户的模块的业务逻辑
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    // 获取客户列表
    public List<Customer> findAllCustomer(){
        return customerMapper.selectAllUnassignedCustomer();
    }


}
