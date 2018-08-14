package com.crm.controller.custom_service;

import com.crm.VO.ResultVO;
import com.crm.entity.ComplainRecord;
import com.crm.service.custom_service.ComplaintRecordService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ComplainRecordController {
@Autowired
    private ComplaintRecordService complaintRecordService;
    @GetMapping("console/customer_complaint")
    public ResultVO findone(@RequestParam("id") Long id)
    {       if(complaintRecordService.findone(id)==null){
        return ResultVOUtil.error();
    }
    else
        return ResultVOUtil.success( complaintRecordService.findone(id));
    }
}


