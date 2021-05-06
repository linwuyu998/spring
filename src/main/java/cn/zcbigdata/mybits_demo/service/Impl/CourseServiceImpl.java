package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Course;
import cn.zcbigdata.mybits_demo.mapper.CourseMapper;
import cn.zcbigdata.mybits_demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.courseMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int SelectCount() {
        return this.courseMapper.SelectCount();
    }

    @Override
    public int insert(Course course) {
        return this.courseMapper.insert(course);
    }

    @Override
    public Course selectByCoursename(String coursename) {
        return this.courseMapper.selectByCoursename(coursename);
    }
}
