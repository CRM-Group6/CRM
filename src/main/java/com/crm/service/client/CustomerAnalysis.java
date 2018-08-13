package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.entity.ShowList;

import java.util.List;

public interface CustomerAnalysis {
    /**
     * @Author: Ben wu
     * @Description: 通过区域来分析客户
     * @Date:Created in 10:55 2018/8/13
     * @Modify By: Ben wu
     * @Param: null
     * @return List
     */
    List<ShowList<Customer>> customerRegionAnalysis();
    /**
     * @Author: Ben wu
     * @Description: 通过客户的来源来分析
     * @Date: Created in 11:03 2018/8/13
     * @Modify By: Ben wu
      * @Param: null
     * @return
     */
    List<ShowList<Customer>> customerSourceAnalysis();
    /**
     * @Author: Ben wu
     * @Description: 通过客户类型来分析
     * @Date: Created in 11:03 2018/8/13
     * @Modify By: Ben wu
      * @Param: null
     * @return
     */
    List<ShowList<Customer>> customerTypeAnalysis();
    /**
     * @Author: Ben wu
     * @Description: 通过客户的行业来分析
     * @Date: Created in 11:04 2018/8/13
     * @Modify By: Ben wu
      * @Param: null
     * @return
     */
    List<ShowList<Customer>> customerIndustryAnalysis();

}
