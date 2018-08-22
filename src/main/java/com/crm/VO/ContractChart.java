package com.crm.VO;

import lombok.Data;

/**
 * @author Quinn
 * @Title: ContractChart
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/2110:16
 */
@Data
public class ContractChart {


        private String name;
        private double y;

        public ContractChart(String name, double y) {
            this.name = name;
            this.y = y;
        }

        public ContractChart() {
        }
}
