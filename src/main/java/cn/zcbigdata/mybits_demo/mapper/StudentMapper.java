package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Student;

public interface StudentMapper {
    Student find(String number);
    Student changepassword(String number, int phonenumber);
    int update(Student student1);
}
