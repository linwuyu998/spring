package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Discuss;
import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.entity.Task;

import java.util.List;

public interface Student1Mapper {
    int insert(Student student);
    int deleteById(int id);
    int update(Student student);
    List<Student> selectAll(int pageindex, int pagesize);
    Student videoselect(String videoname);
    int discussinsert(Discuss discuss);
    List<Task> taskselect(int pageindex, int pagesize);
    List<Discuss> discussselect(int pageindex, int pagesize);
    int SelectCount();
    int taskSelectCount();
    int discussSelectCount();
    int taskupdate(Task task);
    Student selectById(String number);
}
