package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.entity.Manager;
import cn.zcbigdata.mybits_demo.entity.Student;
import cn.zcbigdata.mybits_demo.entity.Teacher;
import cn.zcbigdata.mybits_demo.entity.User;
import cn.zcbigdata.mybits_demo.service.ManagerService;
import cn.zcbigdata.mybits_demo.service.StudentService;
import cn.zcbigdata.mybits_demo.service.TeacherService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;


@Controller
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    private ManagerService managerService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/back")
    public String back() {
        return "/back";
    }

    @RequestMapping("/content")
    public String content() {
        return "content";
    }
    @RequestMapping("/course")
    public String course() {
        return "course";
    }
    @RequestMapping("/discuss")
    public String discuss() {
        return "discuss";
    }
    @RequestMapping("/task1")
    public String task1() {
        return "task1";
    }
    @RequestMapping("/studenttask")
    public String studenttask() {
        return "studenttask";
    }
    @RequestMapping("/teacher")
    public String teacher() {
        return "teacher";
    }
    @RequestMapping("/student")
    public String student() {
        return "student";
    }
    @RequestMapping("/video")
    public String video() {
        return "video";
    }
    @RequestMapping("/discuss1")
    public String discuss1() {
        return "discuss1";
    }



    @RequestMapping("{ip}")
    public String ip(@PathVariable String ip) {
        return "" + ip + "";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String login(@RequestParam("flag") String flag, @RequestParam("account") String account, @RequestParam("password") String password, HttpServletRequest request) {
        Integer integerflag = Integer.valueOf(flag);

        String number = "";
        //String data = "";
        HttpSession session = request.getSession();
        User user = new User();

        // 登录操作
        if (integerflag == 0) {
            Manager manager = managerService.find(account);
            if (manager.getPassword().equals(password)) {
                number = manager.getNumber();
                return "back";


            }

        } else if (integerflag == 1) {
            Student student = studentService.find(account);
            if (student.getPassword().equals(password)) {
                number = student.getNumber();

            }
        } else if (integerflag == 2) {
            Teacher teacher = teacherService.find(account);
            if (teacher.getPassword().equals(password)) {
                number = teacher.getNumber();

            }
        }


        if (null != session.getAttribute("loginUser")) {
            // 清除旧的用户
            session.removeAttribute("loginUser");
        }
        // 新登录，需要构建一个用户
        // 随机生成一个用户
        String id = UUID.randomUUID().toString();
        user.setId(id);
        System.out.println(id + "****************");
        // 将用户放入session
        session.setAttribute("loginUser", user);
        session.setAttribute("number", number);

        // 将登录信息放入数据库，便于协查跟踪聊天者
        System.out.println("新用户诞生了：" + user);
        return number;


    }
}




