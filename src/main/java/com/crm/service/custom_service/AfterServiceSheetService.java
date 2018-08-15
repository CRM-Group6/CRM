package com.crm.service.custom_service;

import com.crm.entity.AfterServiceSheet;
import com.crm.mapper.AfterServiceSheetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AfterServiceSheetService {
    @Autowired
    private AfterServiceSheetMapper  afterServiceSheetMapper;

    public AfterServiceSheet findone(Long id){return afterServiceSheetMapper.selectByPrimaryKey(id);}
}
