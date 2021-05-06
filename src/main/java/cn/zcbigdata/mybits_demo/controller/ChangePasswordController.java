package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.service.StudentService;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ChangePasswordController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;



    @RequestMapping(value = "/ChangePassword",method = RequestMethod.GET)
    @ResponseBody
    public String ChangePassword(@RequestParam("flag") String flag, @RequestParam("account") String account, @RequestParam("password") String password, @RequestParam("phonenumber") int phonenumber , HttpServletRequest request){
        Integer integerflag = Integer.valueOf(flag);
        String data="";
         if (integerflag == 1) {
            Student student = studentService.changepassword(account,phonenumber);
             System.out.println(student);
            if (student!=null) {
                Student student1 =new Student();
                student1.setNumber(account);
                student1.setPassword(password);
                studentService.update(student1);
                 data = "{\"data\":\"修改密码成功\"}";
            }else{
                data = "{\"data\":\"修改密码失败\"}";
            }
        } else if (integerflag == 2) {
            Teacher teacher = teacherService.changepassword(account,phonenumber);
             System.out.println(teacher);
             if(teacher!=null){
                 Teacher teacher1=new Teacher();
                 teacher1.setPassword(password);
                 teacher1.setNumber(account);
                 teacherService.update(teacher1);
             }

        }
         return data;
    }
}
