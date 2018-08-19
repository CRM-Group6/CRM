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

    public  List<AfterServiceSheet> selectAll(){return  afterServiceSheetMapper.selectAll();}

    public int addone(AfterServiceSheet afterServiceSheet){return afterServiceSheetMapper.insert(afterServiceSheet); }

    public int deleteone(Long id ){return  afterServiceSheetMapper.deleteByPrimaryKey(id);}
    //    修改，但是参数是一个problemLibrary
    public int updateone(AfterServiceSheet afterServiceSheet){return afterServiceSheetMapper.updateByPrimaryKey(afterServiceSheet);}
}
