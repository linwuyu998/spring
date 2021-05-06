package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.mapper.StudentMapper;
import cn.zcbigdata.mybits_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

   @Autowired
    StudentMapper studentMapper;


    @Override
    public Student find(String number) {
        return this.studentMapper.find(number);
    }

    @Override
    public Student changepassword(String number, int phonenumber) {
        return this.studentMapper.changepassword(number,phonenumber);
    }

    @Override
    public int update(Student student1) {
        return this.studentMapper.update(student1);
    }


}
