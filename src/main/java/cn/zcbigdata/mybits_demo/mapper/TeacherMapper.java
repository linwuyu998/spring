package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Teacher;

public interface TeacherMapper {
    Teacher find(String number);
    Teacher changepassword(String number, int phonenumber);
    int update(Teacher teacher1);
}
