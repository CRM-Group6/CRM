package com.crm.utils;

import java.util.Random;

/**
 * @author Quinn
 * @Title: KeyUtils
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/209:21
 */
public class KeyUtils {
    public static Long getUniqueKey(){
        Random random = new Random();
        Integer a = random.nextInt(900000)+100000;
        return (Long) (System.currentTimeMillis()+Integer.valueOf(a));
    }
}
