package com.crm.controller.custom_service;

import com.crm.VO.ResultVO;
import com.crm.entity.ProblemLibrary;
import com.crm.service.custom_service.ProblemLibraryService;
import com.crm.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/problem")
public class ProblemLibraryController {
    @Autowired
    private ProblemLibraryService problemLibraryService;
    @GetMapping("/find/{id}")
    public ResultVO findone(@PathVariable("id") Long id)
    {
            return ResultVOUtil.success( problemLibraryService.findone(id));
    }

}
