package com.crm.controller.custom_service;


import com.crm.VO.ResultVO;
import com.crm.entity.AfterServiceSheet;
import com.crm.mapper.AfterServiceProjectMapper;
import com.crm.service.custom_service.AfterServiceProjectService;
import com.crm.service.custom_service.AfterServiceSheetService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AfterServiceProjectController {
@Autowired
    private AfterServiceProjectService afterServiceProjectService;
@GetMapping("console/maintain")
    public ResultVO findone(@RequestParam("id") Long id)
    {

        return ResultVOUtil.success( afterServiceProjectService.findone(id));
    }
}
