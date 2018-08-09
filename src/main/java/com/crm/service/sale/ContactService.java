package com.crm.service.sale;

import com.crm.entity.Contact;
import com.crm.mapper.sale.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系人管理
 * Created by JackKo
 * 2018/8/8 14:53
 **/
@Service
public class ContactService {

    @Autowired
    private ContactMapper contactMapper;

    /**
     * 增加联系人
     */
    public int addContact(Contact contact){
        return contactMapper.insert(contact);
    }

    /**
     * 修改联系人
     */
    public int changeContact(Contact contact){
        return contactMapper.updateByPrimaryKey(contact);
    }

    /**
     * 查找一个联系人
     */
    public Contact findOne(Long id){
        return contactMapper.selectByPrimaryKey(id);
    }

    /**
     * 显示所有联系人
     */
    public List<Contact> findAll(){
        return contactMapper.selectAll();

    }

    /**
     * 删除联系人
     */
    public int deleteContact(Long id){
        return contactMapper.deleteByPrimaryKey(id);
    }
}
