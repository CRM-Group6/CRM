package com.crm.controller.finance;

import com.crm.VO.ResultVO;
import com.crm.entity.Bill;
import com.crm.entity.finance.BillChart;
import com.crm.entity.finance.BillStatistic;
import com.crm.service.finance.BillService;
import com.crm.utils.ResultVOUtil;
import com.sun.org.glassfish.external.amx.BootAMXMBean;
import io.netty.channel.local.LocalEventLoopGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("/bill")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping("/bill/list")
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("finance/bill_management");
        model.addObject("billList", billService.getBillList());
        return model;
    }

    //跳转增加页面
    @RequestMapping("/addforbill")
    public ModelAndView toAdd() {
        //System.out.println("TOADD");
        return new ModelAndView("/finance/bill_add");
    }

    @RequestMapping("/addbill")
    public ModelAndView add(Bill bill) {
        billService.insert(bill);
        return new ModelAndView("redirect:/bill/list");
    }
    /*删除一条数据*/

    @RequestMapping("/billdelete")
    public ModelAndView delete(Long id) {
        billService.deleteBill(id);
        return new ModelAndView("redirect:/bill/list");
    }

    //    更新数据
    @RequestMapping("/billupdate")
    public ModelAndView edit(Bill bill) {
        billService.updateBill(bill);
        return new ModelAndView("redirect:/bill/list");
    }

    /*修改update跳转按钮*/
    @RequestMapping("/billupdatepage")
    public ModelAndView editpage(Long id) {
        ModelAndView model = new ModelAndView("/finance/bill_edit");
        model.addObject("bill", billService.findBill(id));
        return model;
    }

    @RequestMapping("/billstatisticpage")
    public ModelAndView billstatisticpage(){
        return new ModelAndView("/finance/chart");
    }

    @ResponseBody
    @RequestMapping("/billstatistic")
    public List<BillChart> billStatistic(){
        String year = "2018";
        List<BillStatistic> billStatistics = billService.selectByDate(year, 1);
        List<BillStatistic> billStatistics1=billService.selectByDate(year,0);
        List<Double> list1=new ArrayList<Double>();
        List<Double> list = new ArrayList<Double>();
        for (int n = 0; n < 12; n++) {
            list1.add(new Double(0));
            for (int m = 0; m < billStatistics1.size(); m++) {
                int l = Integer.valueOf(billStatistics1.get(m).getMonth()).intValue();
                if (l == n+1) {
                    list1.set(n, billStatistics1.get(m).getMoney());
                }
            }
        }
        for (int i = 0; i < 12; i++) {
            list.add(new Double(0));
            for (int j = 0; j < billStatistics.size(); j++) {
                int z = Integer.valueOf(billStatistics.get(j).getMonth()).intValue();
                if (z == i+1) {
                    list.set(i, billStatistics.get(j).getMoney());
                }
            }
        }
        BillChart billChart = new BillChart("全年支出情况", list);
        BillChart billChart1 = new BillChart("全年收入情况", list1);
        List<BillChart> billCharts=new ArrayList<>();
        billCharts.add(billChart);
        billCharts.add(billChart1);
        return billCharts;
    }



    //    @GetMapping("/findbill")
//    public Bill oneBill(Bill bill){
//        return billService.findBill(bill.getId());
//    }
//    @GetMapping("/deletebill/{id}")
//    public int deleteone(@PathVariable("id") Long id){
//        return billService.deleteBill(id);
//    }

//    @GetMapping("/findPay/{type}")
//    public ResultVO payBillList(@PathVariable("type")Integer type){
//        List<Bill> list=billService.selectByType(type);
//        return ResultVOUtil.success(list);
//    }
@RequestMapping("/findpaybill")
public ModelAndView paylist(@RequestParam("type") Integer type){
    ModelAndView model = new ModelAndView("finance/bill_management");
    model.addObject("billList",billService.selectByType(type));
    return model;
}
}
