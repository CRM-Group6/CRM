package com.crm.service.client;

import com.crm.entity.Customer;
import com.crm.entity.Region;
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
    List<ShowList<Customer,Region>> customerRegionAnalysis();
    /**
     * @Author: Ben wu
     * @Description: 通过客户的来源来分析
     * @Date: Created in 11:03 2018/8/13
     * @Modify By: Ben wu
      * @Param: null
     * @return
     */
    List<ShowList<Customer,String>> customerSourceAnalysis();
    /**
     * @Author: Ben wu
     * @Description: 通过客户的行业来分析
     * @Date: Created in 11:04 2018/8/13
     * @Modify By: Ben wu
      * @Param: null
     * @return
     */
    List<ShowList<Customer,String>> customerIndustryAnalysis();
    /**
     * @Author: Ben wu
     * @Description: 寻找客户列表中的所有地区信息
     * @Date: Created in 15:20 2018/8/13
     * @Modify By: Ben wu
      * @Param: null
     * @return List<Region>
     */
    List<Region> findAllPossibleRegion();
    /**
     * @Author: Ben wu
     * @Description: 寻找同一地区的所有客户
     * @Date: Created in 15:21 2018/8/13
     * @Modify By: Ben wu
      * @Param: Region
     * @return List<Customer>
     */
    List<Customer> findAllCustomerByRegion(Region region);
}
