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
//    查询
    public ProblemLibrary findone(Long id){
       return problemLibraryMapper.selectByPrimaryKey(id); }

//    插入
    public int addone(ProblemLibrary problemLibrary){return problemLibraryMapper.insert(problemLibrary);}
//    删除
    public int deleteone(Long id ){return  problemLibraryMapper.deleteByPrimaryKey(id);}
//    修改，但是参数是一个problemLibrary
    public int updateone(ProblemLibrary problemLibrary){return problemLibraryMapper.updateByPrimaryKey(problemLibrary);}

    public List<ProblemLibrary> selectAll(){
        return problemLibraryMapper.selectAll();
    }
}
