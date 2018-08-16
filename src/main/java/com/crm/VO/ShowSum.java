package com.crm.VO;

import lombok.Data;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 14:52 2018/8/16
 * @Modify By:
 */
@Data
public class ShowSum {
    private String msg;
    private int num;
    public ShowSum(String msg,int num){
        this.msg = msg;
        this.num = num;
    }
}
