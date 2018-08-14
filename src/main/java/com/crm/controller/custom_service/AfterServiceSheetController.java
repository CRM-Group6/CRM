package com.crm.controller.custom_service;


import com.crm.VO.ResultVO;
import com.crm.entity.AfterServiceSheet;
import com.crm.service.custom_service.AfterServiceSheetService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AfterServiceSheetController {
    @Autowired
    private AfterServiceSheetService afterServiceSheetService;

    @GetMapping("console/")
    public ResultVO findone(@RequestParam("id") Long id)
    {

        return ResultVOUtil.success( afterServiceSheetService.findone(id));
    }
}
