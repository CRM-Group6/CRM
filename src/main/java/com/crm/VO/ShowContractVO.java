package com.crm.VO;

import lombok.Data;

/**
 * @author Quinn
 * @Title: ShowVO
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/2110:08
 */
@Data
//数据库获取的信息，保存在这个类里（数据类型要对应）
public class ShowContractVO {
    private int msg;
    private Long num;
    public ShowContractVO(int msg,Long num){
        this.msg = msg;
        this.num = num;
    }
}
