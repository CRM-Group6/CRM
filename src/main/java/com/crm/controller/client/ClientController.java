package com.crm.controller.client;

import com.crm.VO.ResultVO;
import com.crm.entity.Customer;
import com.crm.service.client.ClientService;
import com.crm.service.client.CustomerService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private CustomerService customerService;
    //查看商旅咨询
    @GetMapping(value="/travel")
    public ModelAndView findTravelInfo(){
        ModelAndView model = new ModelAndView("/client/client_information");
        model.addObject("info",clientService.findTravelInfo());
        model.addObject("type","商旅资讯");
        return model;
    }
    //查看特价信息
    @GetMapping(value="/bargain")
    public ModelAndView findBargainInfo(){
        ModelAndView model = new ModelAndView("/client/client_information");
        model.addObject("info",clientService.findBargainInfo());
        model.addObject("type","特价信息");
        return model;
    }
    //查看通告
    @GetMapping(value="/broadcast")
    public ModelAndView findBroadCastInfo(){
        ModelAndView model = new ModelAndView("/client/client_information");
        model.addObject("info",clientService.findBroadCastInfo());
        model.addObject("type","通告");
        return model;
    }
    //查看用户订单
    @GetMapping(value="/orderList")
    public ModelAndView findOrderList(@RequestParam("account") String account){
        Customer customer =  customerService.gettByAccount(account);
        ModelAndView model = new ModelAndView("/client/client_orderList");
        model.addObject("orderList",clientService.findAllOrderList(customer));
        return model;
    }
    //查看用户账单
    @GetMapping(value="/bill")
    public ModelAndView findBill(@RequestParam("account")  String account){
        Customer customer =  customerService.gettByAccount(account);
        ModelAndView model = new ModelAndView("/client/client_bill");
        model.addObject("billList",clientService.findAllBill(customer));
        return model;
    }
    //查找专员客服人员
    @GetMapping(value="/serviceStaff")
    public ModelAndView findServiceStaff(@RequestParam("account") String account){
        Customer customer =  customerService.gettByAccount(account);
        ModelAndView model = new ModelAndView("");
        model.addObject("staff",clientService.findCustomerServiceStaff(customer));
        return model;
    }
}
