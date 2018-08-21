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
public class ShowContractVO {
    private int msg;
    private Long num;
    public ShowContractVO(int msg,Long num){
        this.msg = msg;
        this.num = num;
    }
}
