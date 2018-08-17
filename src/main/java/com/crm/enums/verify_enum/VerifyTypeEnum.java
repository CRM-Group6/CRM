package com.crm.enums.verify_enum;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Quinn
 * @Title: VerifyTypeEnum
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/815:57
 */
@Getter
public enum VerifyTypeEnum {
    CHECKED(Boolean.TRUE,"已审核"),
    UNCHECKED(Boolean.FALSE,"未审核");
  //  CHECKING(2,"正在审核");

    private  Boolean code;
    private String msg;

    VerifyTypeEnum(Boolean code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
