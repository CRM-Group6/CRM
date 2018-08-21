package com.crm.controller.contract_controller;

import com.crm.VO.ResultVO;
import com.crm.VO.chart.Chart;
import com.crm.VO.chart.ChartVO;
import com.crm.VO.chart.ToolTip;
import com.crm.entity.Contract;
import com.crm.entity.ContractStatistic;
import com.crm.entity.Customer;
import com.crm.entity.finance.BillStatistic;
import com.crm.service.client.CustomerService;
import com.crm.service.contract_service.ContractService;
import com.crm.service.contract_service.ContractStatisticsService;
import com.crm.utils.KeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.List;

/**
 * @author Quinn
 * @Title: ContractController
 * @ProjectName CRM
 * @Description: TODO
 * @date 2018/8/916:49
 */
@RestController
@RequestMapping(value = "/contract")
public class ContractController {
   // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractStatisticsService service;
    @Autowired
    CustomerService customerService;
    PageRequest request = PageRequest.of(0,1);
    @GetMapping(value = "/list")
    //组合查询&查询
    public ModelAndView list(Contract contract){

        ModelAndView model = new ModelAndView("contract_information_management");
        model.addObject("contracts",contractService.findAll(request));
        return model;

    }
    @GetMapping(value = "/deleteContract")
    //组合查询&查询
    public ModelAndView deleteContract(Long id){
        contractService.deleteContract(id);
        return new ModelAndView("redirect:/contract/list");

    }
    @RequestMapping("/findById")

    public ModelAndView findById(Long id){
        if (id == null){
            return new ModelAndView("redirect:/contract/list");
        }
        ModelAndView model = new ModelAndView("contract_information_management");
        model.addObject("contracts",contractService.findById(id));
        return model;
    }
    @RequestMapping("/toInsert")
    public ModelAndView toInsert(){
        //System.out.println("TOADD");
        return  new ModelAndView("/contract_information_management_add");
    }

    //插入合同
    @RequestMapping("/insert")
    public ModelAndView insert( Contract contract){

          Contract contract1 = new Contract();
//          if(contract.getId()==null) throw Exception{
//            result.setMsg("合同ID不能为空");
//        }判断字段是否为空

          contract1.setId(KeyUtils.getUniqueKey());
         //添加一个匹配顾客是否存在的判断
//        if(customerService.(contract.getClientId())==null)
//        {
//            return null;
//        }
//        else{
            contract1.setClientId(contract.getClientId());
        //以下内容为必填

          contract1.setSalesmanId(contract.getSalesmanId());
          contract1.setVerifyStatus(contract.getVerifyStatus());
          contract1.setVerifyOpinion(contract.getVerifyOpinion());
          contract1.setCategory(contract.getCategory());
          contract1.setDetails(contract.getDetails());
          contract1.setMoney(contract.getMoney());
          contract1.setExecuteStatus(contract.getExecuteStatus());
//          contract1.setCreateDate(Instant.now().toEpochMilli());
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
//        String  date = df.format(new Date());
//         contract1.setDeadline(date);
        c.add(Calendar.DAY_OF_MONTH, 30);//添加时间
        contract1.setDeadline(df.format(c.getTime()));
          contractService.insertSelective(contract1);

//            return  "redict:/mian";
        return  new ModelAndView("redirect:/contract/list");
    }
    //审核合同
    @RequestMapping(value = "/update")
    public ModelAndView update(Long id){

        Contract contract1 = contractService.findById(id);
        contract1.setVerifyStatus(contract1.getVerifyStatus()?false:true);
        contractService.checkedContract(contract1);
        return new ModelAndView("redirect:/contract/list");
    }
//    @RequestMapping(value = "/check", method = RequestMethod.POST)
//    public ModelAndView check(Contract contract){
//        Contract contract1 = contractService.findById(contract.getId());
//        contract1.setVerifyStatus(contract.getVerifyStatus());
//        contractService.checkedContract(contract1);
//        return new ModelAndView("/list");
//    }

    @RequestMapping(path = "/tongJiList")
    public  ModelAndView TongjiList(Contract contract){
        ModelAndView model = new ModelAndView("contract_information_management_tongji");
        model.addObject("contracts",contractService.findAll(request));
        return model;
    }
    @RequestMapping(path = "/statistics")
    //统计合同数量
    public  ModelAndView Tonji(Contract  contract1){
        ModelAndView model = new ModelAndView("contract_information_management_tongji");

        model.addObject("contracts",contractService.statistics(contract1));
        model.addObject("number",service.statisticsByCombination(contract1));
        return model;
    }
    @RequestMapping("/contractstatisticpage")
    public ModelAndView contractStatistic(){
        String year = "2018";
        List<ContractStatistic> contracts = contractService.selectByDate(year, 1);
        List<ContractStatistic> contracts1=contractService.selectByDate(year,0);
        List<Double> list1=new ArrayList<Double>();
        List<Double> list = new ArrayList<Double>();
        for (int n = 0; n < 12; n++) {
            list1.add(new Double(0));
            for (int m = 0; m < contracts.size(); m++) {
                int l = Integer.valueOf(contracts.get(m).getMonth()).intValue();
                if (l == n+1) {
                    list1.set(n, contracts1.get(m).getMoney());
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            list.add(new Double(0));
            for (int j = 0; j < contracts.size(); j++) {
                int z = Integer.valueOf(contracts.get(j).getMonth()).intValue();
                if (z == i+1) {
                    list.set(i, contracts.get(j).getMoney());
                }
            }
        }
        Chart chart = new Chart("全年支出情况", list);
        Chart chart1 = new Chart("全年收入情况", list1);
        List<Chart> charts =new ArrayList<>();
        charts.add(chart);
        charts.add(chart1);
        List<String> date=new ArrayList<String>();
        date.add("一月");date.add("二月");date.add("三月");date.add("四月");date.add("五月");
        date.add("六月");date.add("七月");date.add("八月");date.add("九月");date.add("十月");
        date.add("十一月");date.add("十二月");
        ChartVO chartVO =new ChartVO(charts,"时间","金额",date,"四川铁航财务统计");
        ToolTip toolTip = new ToolTip();
        toolTip.setValueSuffix("元");
        toolTip.setValuePrefix("￥");
        chartVO.setToolTip(toolTip);
        ModelAndView model = new ModelAndView("/contract/chart");
        model.addObject("result",chartVO);
        return model;
    }






}
