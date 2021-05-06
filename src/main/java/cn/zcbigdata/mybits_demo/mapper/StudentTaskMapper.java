package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.StudentTask;

import java.util.List;

public interface StudentTaskMapper {
    List<StudentTask> selectAll(int pageIndex, int pageSize);
    int SelectCount();
    int insert(StudentTask studentTask);
    int update(StudentTask studentTask);
    int deleteById(int id);
}
