package com.crm.service.sale;

import com.crm.entity.ExchangeInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by JackKo
 * 2018/8/9 17:09
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExchangeInfoServiceTest {

    @Autowired
    private ExchangeInfoService exchangeInfoService;

    @Test
    public void addExchangeInfo() {
//        ExchangeInfo newExchange = new ExchangeInfo();
//        newExchange.setId(new Long((long)1));
//        newExchange.setContactId(new Long((long)3));
//        newExchange.setExecutorId(new Long((long)2));
//        int result = exchangeInfoService.addExchangeInfo(newExchange);
//        System.out.println("添加：" + result);
    }

    @Test
    public void changeExchangeInfo() {
        ExchangeInfo newExchange = new ExchangeInfo();
        newExchange.setId(new Long((long)2));
        newExchange.setContactId(new Long((long)5));
        newExchange.setExecutorId(new Long((long)2));
        int result = exchangeInfoService.changeExchangeInfo(newExchange);
        System.out.println("修改：" + result);
    }

    @Test
    public void findOne() {
        ExchangeInfo result = exchangeInfoService.findOne(new Long((long)2));
        System.out.println("查找一个：" + result.getExecutorId());
    }

    @Test
    public void findAll() {
        List<ExchangeInfo> list = exchangeInfoService.findAll();
        System.out.println("查找全部：" + list.toString());
    }

    @Test
    public void deleteExchangeInfo() {
        int result = exchangeInfoService.deleteExchangeInfo(new Long((long)3));
        System.out.println("删除：" + result);
    }
}