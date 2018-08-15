package com.crm.service.custom_service;

import com.crm.entity.AfterServiceProject;
import com.crm.mapper.AfterServiceProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AfterServiceProjectService {
    @Autowired
    private AfterServiceProjectMapper afterServiceProjectMapper;

    public AfterServiceProject findone(Long id){ return afterServiceProjectMapper.selectByPrimaryKey(id);}
}
