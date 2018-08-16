package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.entity.User;
import com.crm.enums.Department;
import com.crm.mapper.CustomerMapper;
import com.crm.mapper.UserMapper;
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
    @Autowired
    private UserMapper userMapper;

    // 获取未分配客服的客户列表
    public List<Customer> findAllUnassignedCustomer(){
        return customerMapper.selectAllUnassignedCustomer();
    }
    // 获取所有客服
    public List<User> findAllCustomerServiceStaff(){
        return  userMapper.selectByDepartment(Department.CUSTOMER_SERVICE.getIndex());
    }
    // 指派一个客服到客户（通过ID设置）
    public boolean setCustomerServiceStaff(Customer customer,User user){
        //如果员工为客服则进行设置
        if(user.getDepartment().equals(Department.CUSTOMER_SERVICE.getIndex())){
            //设置用户的客服ID
            customer.setCustomServiceId(user.getId());
            //保存客户
            customerMapper.updateByPrimaryKeySelective(customer);
            return true;
        }else{
            System.err.println("客户不能被赋予非客服人员");
            return false;
        }
    }
}
