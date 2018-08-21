package com.crm.service.client;

import com.crm.VO.client.ShowRegionSum;
import com.crm.VO.ShowSum;

import java.util.List;

public interface CustomerAnalysis {
    /**
     * @return List
     * @Author: Ben wu
     * @Description: 通过区域来分析客户
     * @Date:Created in 10:55 2018/8/13
     * @Modify By: Ben wu
     * @Param: null
     */
    List<ShowRegionSum> customerRegionAnalysis();

    /**
     * @return
     * @Author: Ben wu
     * @Description: 通过客户的来源来分析
     * @Date: Created in 11:03 2018/8/13
     * @Modify By: Ben wu
     * @Param: null
     */
    List<ShowSum> customerSourceAnalysis();

    /**
     * @return
     * @Author: Ben wu
     * @Description: 通过客户的行业来分析
     * @Date: Created in 11:04 2018/8/13
     * @Modify By: Ben wu
     * @Param: null
     */
    List<ShowSum> customerIndustryAnalysis();
}
