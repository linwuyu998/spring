package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.StudentTask;

import java.util.List;

public interface StudentTaskService {


    int SelectCount();

    List<StudentTask> selectAll(int pageInteger, int limitInteger);

    int insert(StudentTask studentTask);

    int update(StudentTask studentTask);

    int deleteById(int id);
}
