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

    public AfterServiceProject findone(Long id){return afterServiceProjectMapper.selectByPrimaryKey(id);}

    public  List<AfterServiceProject> selectAll(){return  afterServiceProjectMapper.selectAll();}

    public int addone(AfterServiceProject afterServiceProject){return afterServiceProjectMapper.insert(afterServiceProject); }

    public int deleteone(Long id ){return  afterServiceProjectMapper.deleteByPrimaryKey(id);}
    //    修改，但是参数是一个problemLibrary
    public int updateone(AfterServiceProject afterServiceProject){return afterServiceProjectMapper.updateByPrimaryKey(afterServiceProject);}
}
