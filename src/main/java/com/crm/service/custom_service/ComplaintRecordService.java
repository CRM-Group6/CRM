package com.crm.service.custom_service;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.crm.entity.ComplainRecord;
import com.crm.entity.ProblemLibrary;
import com.crm.enums.customer_services.ExecutedStatus;
import com.crm.mapper.ComplainRecordMapper;

import com.crm.utils.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComplaintRecordService {
    @Autowired
    private ComplainRecordMapper complainRecordMapper;
//查询
    public ComplainRecord findone(Long id){return complainRecordMapper.selectByPrimaryKey(id);}

//    插入
    public int addone(ComplainRecord complainRecord){return complainRecordMapper.insert(complainRecord);}
    //    删除
    public int deleteone(Long id ){return  complainRecordMapper.deleteByPrimaryKey(id);}
    //    修改，但是参数是一个problemLibrary
    public int updateone(ComplainRecord complainRecord){return complainRecordMapper.updateByPrimaryKey(complainRecord);}

    public List<ComplainRecord> selectAll(){
        return complainRecordMapper.selectAll();
    }

    public List<ComplainRecord> selectNotArrange(){ return complainRecordMapper.selectNotArrange();}
    public int arrangeStaff(Long id,Long staffId){
        ComplainRecord complainRecord=complainRecordMapper.selectByPrimaryKey(id);
        complainRecord.setExecutorId(staffId);
        complainRecord.setExecuted(ExecutedStatus.EXCUTED.getCode());
        Date date =new Date();
        complainRecord.setExecuteDate(date);
        return complainRecordMapper.updateByPrimaryKey(complainRecord);
    }
    public List<ComplainRecord> selectArranged(){ return complainRecordMapper.selectArranged();}

}
