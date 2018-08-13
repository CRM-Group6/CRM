package com.crm.controller.sys.sale;

import com.crm.entity.Contact;
import com.crm.service.sale.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 联系人管理
 * Created by JackKo
 * 2018/8/13 10:29
 **/
@RestController
@RequestMapping("/sale/contact")
public class ContactManageController {
    @Autowired
    private ContactService contactService;

    //增加联系人
    @GetMapping("/add")
    public int create(Contact contact){
        return contactService.addContact(contact);
    }


    //修改联系人
    @GetMapping("/change")
    public int change(Contact contact){
        return contactService.changeContact(contact);
    }


    //删除联系人
    @GetMapping("/delete/{id}")
    public int delete(@PathVariable Long id){
        return contactService.deleteContact(id);
    }

    //查看所有联系人
    @GetMapping("/see")
    public List<Contact> seeAll(){
        return contactService.findAll();
    }

    //查看单个联系人
    @GetMapping("/see/{id}")
    public Contact seeOne(@PathVariable Long id){
        return contactService.findOne(id);
    }
}
