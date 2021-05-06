package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Teacher;

import java.util.List;

public interface Teacher1Mapper {
    int insert(Teacher teacher);
    int deleteById(int id);
    int update(Teacher teacher);
    List<Teacher> selectAll(int pageindex, int pagesize);
    int SelectCount();
}
