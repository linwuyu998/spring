package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.mapper.TeacherMapper;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    TeacherMapper teacherMapper;


    @Override
    public Teacher find(String number) {
        return this.teacherMapper.find(number);
    }

    @Override
    public Teacher changepassword(String number, int phonenumber) {
        return this.teacherMapper.changepassword(number,phonenumber);
    }

    @Override
    public int update(Teacher teacher1) {
        return this.teacherMapper.update(teacher1);
    }
}
