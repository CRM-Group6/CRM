package com.crm.controller.contract_controller;

import com.crm.VO.ShowContractVO;
import com.crm.VO.chart.*;
import com.crm.entity.Contract;
import com.crm.service.client.CustomerService;
import com.crm.service.contract_service.ContractService;
import com.crm.service.contract_service.ContractStatisticsService;
import com.crm.utils.KeyUtils;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
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

        ModelAndView model = new ModelAndView("/contract/contract_information_management");
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
        ModelAndView model = new ModelAndView("/contract/contract_information_management");
        model.addObject("contracts",contractService.findById(id));
        return model;
    }
    @RequestMapping("/toInsert")
    public ModelAndView toInsert(){
        //System.out.println("TOADD");
        return  new ModelAndView("/contract/contract_information_management_add");
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
        ModelAndView model = new ModelAndView("/contract/contract_information_management_tongji");
        model.addObject("contracts",contractService.findAll(request));
        return model;
    }
    @RequestMapping(path = "/statistics")
    //统计合同数量
    public  ModelAndView Tonji(Contract  contract1){
        ModelAndView model = new ModelAndView("/contract/contract_information_management_tongji");

        model.addObject("contracts",contractService.statistics(contract1));

        model.addObject("number",service.statisticsByCombination(contract1));
        return model;
    }

    //合同类型
    @GetMapping(value = "/category")
    private ModelAndView contractRegionAnalysis(){
        List<ShowContractVO> list = contractService.contractRegionAnalysis();
        ModelAndView model= new ModelAndView("/contract/contract_analysis");
        List<PieItem> dataList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
                if(list.get(i).getMsg()==0){
                    PieItem pieItem = new PieItem("收入类型",list.get(i).getNum());
                    dataList.add(pieItem);
                }
                else if(list.get(i).getMsg()==1)
                {
                    PieItem pieItem = new PieItem("支出类型",list.get(i).getNum());
                    dataList.add(pieItem);
                }
                else
                {
                    PieItem pieItem = new PieItem("描述类型",list.get(i).getNum());
                    dataList.add(pieItem);
                }
//            PieItem pieItem = new PieItem(list.get(i).toString(),list.get(i).getNum());

            }

        Pie chart = new Pie("合同类型分析饼图",dataList);
        chart.setType("pie");
        List<Pie> charts = new ArrayList<>();
        charts.add(chart);
        ChartVO chartVO = new ChartVO(charts,null,null,null,"合同类型统计分析");
        if(list!=null){
            return model.addObject("result", ResultVOUtil.success(chartVO));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }
    //来源
    @GetMapping(value = "/execute")
    private ModelAndView customerSourceAnalysis(){
        List<ShowContractVO> list = contractService.contractRegionAnalysis();
        ModelAndView model= new ModelAndView("/contract/contract_analysis");
        List<PieItem> dataList = new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if(list.get(i).getMsg()==1){
                PieItem pieItem = new PieItem("正在执行",list.get(i).getNum());
                dataList.add(pieItem);
            }
            else
            {
                PieItem pieItem = new PieItem("执行完毕",list.get(i).getNum());
                dataList.add(pieItem);
            }
//            PieItem pieItem = new PieItem(list.get(i).toString(),list.get(i).getNum());

        }
        Pie chart = new Pie("运行状态分析饼图",dataList);
        chart.setType("pie");
        List<Pie> charts = new ArrayList<>();
        charts.add(chart);
        ChartVO chartVO = new ChartVO(charts,null,null,null,"合同执行状态统计分析");
        if(list!=null){
            return model.addObject("result",ResultVOUtil.success(chartVO));
        }else
            return model.addObject("result",ResultVOUtil.error());
    }





}
