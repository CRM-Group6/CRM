package com.crm.controller.client;

import com.crm.VO.ResultVO;
import com.crm.entity.Customer;
import com.crm.entity.User;
import com.crm.service.client.CustomerService;
import com.crm.utils.JsonXMLUtils;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 16:52 2018/8/13
 * @Modify By:
 */
@RestController
@RequestMapping("/distribute")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //获取未分配客服的用户列表
    @GetMapping(value="/unassignedCus")
    public ResultVO findUnassignedCustomer(){
        return ResultVOUtil.success(customerService.findAllUnassignedCustomer());
    }
    // 获取所有客服
    @GetMapping(value = "/serviceStaff")
    public ResultVO findAllCustomerServiceStaff(){
        return ResultVOUtil.success(customerService.findAllCustomerServiceStaff());
    }
    // 指派一个客服到客户（通过ID设置）
    @PutMapping(value = "/setStaff")
    public ResultVO setStaffToCus(@RequestBody Map<String, Object> models) throws Exception {
        Customer customer = JsonXMLUtils.map2obj((Map<String,Object>)models.get("customer"),Customer.class);
        User user=JsonXMLUtils.map2obj((Map<String, Object>)models.get("user"),User.class);
        System.out.println(user+"\n"+customer);
        if(customerService.setCustomerServiceStaff(customer,user)){
            return ResultVOUtil.success();
        }else
            return ResultVOUtil.error();
    }
}
