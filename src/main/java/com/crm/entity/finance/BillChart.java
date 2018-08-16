package com.crm.entity.finance;

import lombok.Data;
import org.nustaq.serialization.annotations.Serialize;

import java.util.List;
@Serialize
@Data
public class BillChart {
    String name;
    List<Double> data;
    public BillChart(String name, List<Double> data) {
        this.name = name;
        this.data = data;
    }
}

