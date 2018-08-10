package com.crm.service.sale;

import com.crm.entity.Contact;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * Created by JackKo
 * 2018/8/9 15:33
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void addContact() {
        Contact newContact = new Contact();
        newContact.setId(new Long((long)5));
        newContact.setSalesmanId(new Long((long)1));
        newContact.setName("jackko");
        int result = contactService.addContact(newContact);
        System.out.println("添加：" + result);
    }

    @Test
    public void changeContact() {
        Contact change = new Contact();
        change.setId(new Long((long)3));
        change.setSalesmanId(new Long((long)1));
        change.setArea("55");
        int result2 = contactService.changeContact(change);
        System.out.println("修改：" + result2);
    }

    @Test
    public void findOne() {
        Contact contact = contactService.findOne(new Long((long)3));
        System.out.println("查找：" + contact.getName());
    }

    @Test
    public void findAll() {
        List<Contact> contacts = contactService.findAll();
        System.out.println(contacts.toString());
    }

    @Test
    public void deleteContact() {
        int result = contactService.deleteContact(new Long((long)2));
        System.out.println("删除：" + result);
    }
}