package com.crm.controller.custom_service;

import com.crm.VO.ResultVO;
import com.crm.entity.ProblemLibrary;
import com.crm.service.custom_service.ProblemLibraryService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ProblemLibraryController {
    @Autowired
    private ProblemLibraryService problemLibraryService;
    @GetMapping("console/financial_management")
    public ResultVO findone(@RequestParam("selectrequest") Long id)
    {       if(problemLibraryService.findone(id)==null){
        return ResultVOUtil.error();
        }
        else
            return ResultVOUtil.success( problemLibraryService.findone(id));
    }
   public ResultVO addone(@RequestParam("obj") ProblemLibrary problemLibrary){
        if(problemLibraryService.addone(problemLibrary)==1){

        }
   }


}
