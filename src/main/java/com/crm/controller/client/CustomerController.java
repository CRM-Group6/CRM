package com.crm.controller.client;

import com.crm.VO.ResultVO;
import com.crm.VO.client.ShowServiceStaff;
import com.crm.entity.Customer;
import com.crm.entity.User;
import com.crm.service.client.CustomerService;
import com.crm.utils.JsonXMLUtils;
import com.crm.utils.ResultVOUtil;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
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
    public ModelAndView findUnassignedCustomer(){
        ModelAndView model = new ModelAndView("/client/customer_distribution");
        model.addObject("customerList",customerService.findAllUnassignedCustomer());
        return model;
    }
    // 获取所有客服
    @GetMapping(value = "/serviceStaff")
    public ModelAndView findAllCustomerServiceStaff(Long id){
        ModelAndView model = new ModelAndView("/client/staff_list");
        List<ShowServiceStaff> list = new ArrayList<>();
        List<User> originList = customerService.findAllCustomerServiceStaff();
        for (int i=0;i<originList.size();i++){
            list.add(new ShowServiceStaff(originList.get(i)));
        }
        model.addObject("userList",list);
        model.addObject("customer_id",id);
        return model;
    }
    // 指派一个客服到客户（通过ID设置）
    @RequestMapping(value = "/setStaff")
    public ModelAndView setStaffToCus(@RequestParam("user_id")Long userId,@RequestParam("department")int department,@RequestParam("customer_id")Long customerId) throws Exception {
        User user = new User();
        user.setId(userId);
        user.setDepartment(department);
        Customer customer = new Customer();
        customer.setId(customerId);
        ModelAndView model;
        customerService.setCustomerServiceStaff(customer,user);
        model = new ModelAndView("redirect:/distribute/unassignedCus");
        return model;
    }
    @RequestMapping("/toRegister")
     public ModelAndView toRegister(){
        return new ModelAndView("/cusRegister");
    }

    @RequestMapping("/register")
    public ModelAndView addone(Customer customer){
        customerService.addone(customer);
        return new ModelAndView("redirect:/sys/login");
    }
}
