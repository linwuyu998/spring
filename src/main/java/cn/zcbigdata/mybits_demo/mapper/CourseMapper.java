package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Course;

import java.util.List;

public interface CourseMapper {
    List<Course> selectAll(int pageIndex, int pageSize);
    int SelectCount();

    int insert(Course course);
    Course selectByCoursename(String coursename);
}
