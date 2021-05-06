package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.StudentTask;
import cn.zcbigdata.mybits_demo.mapper.StudentMapper;
import cn.zcbigdata.mybits_demo.mapper.StudentTaskMapper;
import cn.zcbigdata.mybits_demo.service.StudentTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentTaskServiceImpl implements StudentTaskService {
    @Autowired
    private StudentTaskMapper studentTaskMapper;



    @Override
    public int SelectCount() {
        return this.studentTaskMapper.SelectCount();
    }

    @Override
    public List<StudentTask> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.studentTaskMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int insert(StudentTask studentTask) {
        return this.studentTaskMapper.insert(studentTask);
    }

    @Override
    public int update(StudentTask studentTask) {
        return this.studentTaskMapper.update(studentTask);
    }

    @Override
    public int deleteById(int id) {
        return this.studentTaskMapper.deleteById(id);
    }
}
