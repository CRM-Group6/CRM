package com.crm.controller.sys.sale;

import com.crm.VO.ResultVO;
import com.crm.entity.Contact;
import com.crm.service.sale.ContactService;
import com.crm.utils.ResultVOUtil;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping("/add")
    public ResultVO create(@RequestBody Contact contact)  {
//        System.out.println(contact);
        int res = contactService.addContact(contact);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }


    //修改联系人
    @PutMapping("/change")
    public ResultVO change(@RequestBody Contact contact){
        int res = contactService.changeContact(contact);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }


    //删除联系人
    @DeleteMapping("/delete/{id}")
    public ResultVO delete(@PathVariable Long id){
        int res = contactService.deleteContact(id);
        if(res == 0) return ResultVOUtil.error();
        return ResultVOUtil.success(res);
    }

    //查看所有联系人
    @GetMapping("/see")
    public ResultVO seeAll(){
        List<Contact> contactList = contactService.findAll();
        if(contactList == null) return ResultVOUtil.error();
        return ResultVOUtil.success(contactList);
    }

    //查看单个联系人
    @GetMapping("/see/{id}")
    public ResultVO seeOne(@PathVariable Long id){
        Contact result = contactService.findOne(id);
        if(result == null) return ResultVOUtil.error();
        return ResultVOUtil.success(result);
    }
}
