package com.crm.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Mankind on 2018/2/2.
 */
public class LayuiResult {
    public final static int OK = 200;
    public final static int FAIL = 500;
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    // 响应业务状态
    private Integer status;

    // 响应消息1
    private String msg;

    // 响应中的数据
    private Object data;

    public static LayuiResult build(Integer status, String msg, Object data) {
        return new LayuiResult(status, msg, data);
    }

    public static LayuiResult ok(Object data) {
        return new LayuiResult(data);
    }

    public static LayuiResult ok() {
        return new LayuiResult(null);
    }

    public static LayuiResult build(Integer status, String msg) {
        return new LayuiResult(status, msg, null);
    }

    public LayuiResult() {

    }

    public LayuiResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public LayuiResult(Object data) {
        this.msg="OK";
        this.status=OK;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
