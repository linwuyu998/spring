package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Discuss;
import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.entity.Task;
import cn.zcbigdata.mybits_demo.mapper.Student1Mapper;
import cn.zcbigdata.mybits_demo.service.Student1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Student1ServiceImpl implements Student1Service {

    @Autowired
    private Student1Mapper studentMapper;

    @Override
    public int insert(Student student) {
        return this.studentMapper.insert(student);
    }

    @Override
    public int deleteById(int id) {
        return this.studentMapper.deleteById(id);
    }

    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }

    @Override
    public List<Student> selectAll(int pageInteger, int limitInteger){
        int pageindex = (pageInteger-1)*limitInteger;
        int pagesize = limitInteger;
        return this.studentMapper.selectAll(pageindex,pagesize);
    }

    @Override
    public Student videoselect(String videoname){
        return this.studentMapper.videoselect(videoname);
    }

    @Override
    public int discussinsert(Discuss discuss){
        return this.studentMapper.discussinsert(discuss);
    }

    @Override
    public List<Task> taskselect(int pageInteger, int limitInteger){
        int pageindex = (pageInteger-1)*limitInteger;
        int pagesize = limitInteger;
        return this.studentMapper.taskselect(pageindex,pagesize);
    }

    @Override
    public List<Discuss> discussselect(int pageInteger, int limitInteger){
        int pageindex = (pageInteger-1)*limitInteger;
        int pagesize = limitInteger;
        return this.studentMapper.discussselect(pageindex,pagesize);
    }

    @Override
    public int SelectCount() {
        return this.studentMapper.SelectCount();
    }

    @Override
    public int taskSelectCount() {
        return this.studentMapper.SelectCount();
    }

    @Override
    public int discussSelectCount() {
        return this.studentMapper.discussSelectCount();
    }

    @Override
    public int taskupdate(Task task) {
        return this.studentMapper.taskupdate(task);
    }

    @Override
    public Student selectById(String number) {
        return this.studentMapper.selectById(number);
    }


}
