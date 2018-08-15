package com.crm.entity.finance;

import lombok.Data;

import java.util.Date;

@Data
public class BillStatistic {
    private Date searchDate;
    private Double sums;
    private Integer type;
}
