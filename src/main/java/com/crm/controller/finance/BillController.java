package com.crm.controller.finance;

import com.crm.entity.Bill;
import com.crm.service.finance.BillService;
import io.netty.channel.local.LocalEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;
    @GetMapping("/finbill/{id}")
    public Bill oneBill(@PathVariable("id") Long id){
        return billService.findBill(id);
    }
    @GetMapping("/delete/{id}")
    public int deleteone(@PathVariable("id") Long id){
        return billService.deleteBill(id);
    }
}
