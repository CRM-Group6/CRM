package com.crm.service.custom_service;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.crm.entity.ComplainRecord;
import com.crm.mapper.ComplainRecordMapper;

import com.crm.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComplaintRecordService {
    @Autowired
    private ComplainRecordMapper complainRecordMapper;

    public ComplainRecord findone(Long id){return complainRecordMapper.selectByPrimaryKey(id);}

}
