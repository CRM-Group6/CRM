package com.crm.controller.tiaozhuan;

import com.crm.VO.ResultVO;
import com.crm.entity.Customer;
import com.crm.service.client.ClientService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: Ben wu
 * @Description:
 * @Date:Created in 11:27 2018/8/14
 * @Modify By:
 */
@RestController
@RequestMapping("/jump")
public class Jump {
    @RequestMapping("/main")
    public ModelAndView tomain(){
        return new ModelAndView("/mainForCus");
    }

    @RequestMapping("/cusindex")
    public ModelAndView cusindex(){

        return new ModelAndView("/cus_index");
    }
}
