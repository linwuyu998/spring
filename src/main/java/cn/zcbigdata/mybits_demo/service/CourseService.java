package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Course;

import java.util.List;

public interface CourseService {
    

    List<Course> selectAll(int pageInteger, int limitInteger);
    int SelectCount();

    int insert(Course course);

    Course selectByCoursename(String coursename);
}
