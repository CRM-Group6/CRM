package com.crm.controller.client;

import com.crm.VO.ResultVO;
import com.crm.entity.Customer;
import com.crm.service.client.ClientService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 11:27 2018/8/14
 * @Modify By:
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;
    //查看商旅咨询
    @GetMapping(value="/travel")
    public ResultVO findTravelInfo(){
        return ResultVOUtil.success(clientService.findTravelInfo());
    }
    //查看特价信息
    @GetMapping(value="/bargain")
    public ResultVO findBargainInfo(){
        return ResultVOUtil.success(clientService.findBargainInfo());
    }
    //查看通告
    @GetMapping(value="/broadcast")
    public ResultVO findBroadCastInfo(){
        return ResultVOUtil.success(clientService.findBroadCastInfo());
    }
    //查看用户订单
    @GetMapping(value="/orderList")
    public ResultVO findOrderList(@RequestParam("id") Long id){
        Customer customer = new Customer();
        customer.setId(id);
        return ResultVOUtil.success(clientService.findAllOrderList(customer));
    }
    //查看用户账单
    @GetMapping(value="/bill")
    public ResultVO findBill(@RequestParam("id") Long id){
        Customer customer = new Customer();
        customer.setId(id);
        return ResultVOUtil.success(clientService.findAllBill(customer));
    }
    //查找专员客服人员
    @GetMapping(value="/serviceStaff")
    public ResultVO findServiceStaff(@RequestParam("id") Long id){
        Customer customer = new Customer();
        customer.setId(id);
        return ResultVOUtil.success(clientService.findCustomerServiceStaff(customer));
    }
}
