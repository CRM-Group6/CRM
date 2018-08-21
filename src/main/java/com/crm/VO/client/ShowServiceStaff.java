package com.crm.VO.client;

import com.crm.entity.User;
import com.crm.enums.Department;
import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 12:58 2018/8/21
 * @Modify By:
 */
@Data
public class ShowServiceStaff {
    private Long id;            //ID
    private String account;     //账号
    private String username;    //用户名
    private String department; //部门
    public ShowServiceStaff(User user){
        id = user.getId();
        account = user.getAccount();
        username = user.getUsername();
        department = Department.values()[user.getDepartment()-1].getMessage();
    }
}
