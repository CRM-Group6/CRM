package com.crm.service.sale;

import com.crm.entity.ExchangeInfo;
import com.crm.mapper.sale.ExchangeInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 交往信息管理
 * Created by JackKo
 * 2018/8/8 14:53
 **/
@Service
public class ExchangeInfoService {

    @Autowired
    private ExchangeInfoMapper exchangeInfoMapper;

    /**
     * 增加联系人
     */
    public int addExchangeInfo(ExchangeInfo exchangeInfo){
        return exchangeInfoMapper.insert(exchangeInfo);
    }

    /**
     * 修改联系人
     */
    public int changeExchangeInfo(ExchangeInfo exchangeInfo){
        return exchangeInfoMapper.updateByPrimaryKey(exchangeInfo);
    }

    /**
     * 查找一个联系人
     */
    public ExchangeInfo findOne(Long id){
        return exchangeInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 显示所有联系人
     */
    public List<ExchangeInfo> findAll(){
        return exchangeInfoMapper.selectAll();

    }

    /**
     * 删除联系人
     */
    public int deleteExchangeInfo(Long id){
        return exchangeInfoMapper.deleteByPrimaryKey(id);
    }
}
