package com.crm.service.custom_service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.crm.entity.ProblemLibrary;
import com.crm.entity.User;
import com.crm.mapper.ProblemLibraryMapper;
import com.crm.mapper.UserMapper;
import com.crm.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemLibraryService {
    @Autowired
    private ProblemLibraryMapper problemLibraryMapper;

    public ProblemLibrary findone(Long id){
       return problemLibraryMapper.selectByPrimaryKey(id);
    }
}
