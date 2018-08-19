package com.crm.entity.finance;

import lombok.Data;

import java.util.Date;

@Data
public class BillStatistic {
    private String month;
    private Double money;
    private Integer type;
}
