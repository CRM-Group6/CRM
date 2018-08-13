package com.crm.controller.finance;

import com.crm.VO.ResultVO;
import com.crm.entity.Bill;
import com.crm.service.finance.BillService;
import com.crm.utils.ResultVOUtil;
import io.netty.channel.local.LocalEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
//    @GetMapping("/finbill/{id}")
//    public Bill oneBill(@PathVariable("id") Long id){
//        return billService.findBill(id);
//    }
    @GetMapping("/findbill")
    public Bill oneBill(Bill bill){
        return billService.findBill(bill.getId());
    }
    @GetMapping("/deletebill/{id}")
    public int deleteone(@PathVariable("id") Long id){
        return billService.deleteBill(id);
    }

    @GetMapping("/findPay/{type}")
    public ResultVO payBillList(@PathVariable("type")Integer type){
        List<Bill> list=billService.selectByType(type);
        return ResultVOUtil.success(list);
    }
}
