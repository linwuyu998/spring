package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.mapper.Teacher1Mapper;
import cn.zcbigdata.mybits_demo.service.Teacher1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Teacher1ServiceImpl implements Teacher1Service {
    @Autowired
    private Teacher1Mapper teacherMapper1;

    @Override
    public int insert(Teacher teacher){
        return this.teacherMapper1.insert(teacher);
    }

    @Override

    public int deleteById(int id){
        return this.teacherMapper1.deleteById(id);
    }

    @Override
    public int update(Teacher teacher){
        return this.teacherMapper1.update(teacher);
    }

    @Override
    public List<Teacher> selectAll(int pageInteger, int limitInteger) {
        int pageindex = (pageInteger-1)*limitInteger;
        int pagesize = limitInteger;
        return this.teacherMapper1.selectAll(pageindex,pagesize);
    }

    @Override
    public int SelectCount() {
        return this.teacherMapper1.SelectCount();
    }

}
