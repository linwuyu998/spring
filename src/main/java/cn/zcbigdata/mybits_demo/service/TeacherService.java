package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Teacher;

public interface TeacherService {
    Teacher find(String number);

    Teacher changepassword(String number, int phonenumber);

    int update(Teacher teacher1);
}
