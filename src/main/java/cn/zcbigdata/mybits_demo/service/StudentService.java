package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Student;

public interface StudentService {
    Student find(String number);

    Student changepassword(String number, int phonenumber);

    int update(Student student1);
}
