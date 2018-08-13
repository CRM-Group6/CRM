package com.crm.controller.sys.sale;

import com.crm.entity.ExchangeInfo;
import com.crm.service.sale.ExchangeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 交往信息
 * Created by JackKo
 * 2018/8/13 10:33
 **/
@RestController
@RequestMapping("/sale/exchangeInfo")

public class ExchangeManageController {

    @Autowired
    private ExchangeInfoService exchangeInfoService;

    //增加交往信息
    @GetMapping("/add")
    public int create(ExchangeInfo exchangeInfo){
        return exchangeInfoService.addExchangeInfo(exchangeInfo);
    }


    //修改交往信息
    @GetMapping("/change")
    public int change(ExchangeInfo exchangeInfo){
        return exchangeInfoService.changeExchangeInfo(exchangeInfo);
    }


    //删除交往信息
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable Long id){
        return exchangeInfoService.deleteExchangeInfo(id);
    }

    //查看所有交往信息
    @GetMapping("/see")
    public List<ExchangeInfo> seeAll(){
        return exchangeInfoService.findAll();
    }

    //查看单个交往信息
    @GetMapping("/see/{id}")
    public ExchangeInfo seeOne(@PathVariable Long id){
        return exchangeInfoService.findOne(id);
    }
}
