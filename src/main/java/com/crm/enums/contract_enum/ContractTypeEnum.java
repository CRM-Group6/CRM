package com.crm.enums.contract_enum;


import lombok.Getter;

/**
 * @author Quinn
 * @Title: ContractTyprEnum
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/811:48
 */
@Getter
public enum ContractTypeEnum {
    INCOME(0,"收入类"),
    EXPEND(1,"支出类"),
    DESCRIBE(2,"描述类")
    ;
    private Integer code;
    private String msg;
    ContractTypeEnum(int code ,String msg){
        this.code=code;
        this.msg=msg;
    }


}
