package com.crm.VO;

import lombok.Data;

@Data
public class ResultVO <T> {
    private boolean success;
    private String msg;
    private T data;
}
