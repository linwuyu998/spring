package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.*;
import cn.zcbigdata.mybits_demo.service.Student1Service;
import cn.zcbigdata.mybits_demo.service.Teacher1Service;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = Logger.getLogger(TeacherController.class);

    @Autowired
    private Teacher1Service teacherService;
    @Autowired
    private Student1Service studentService;


    @ResponseBody
    @RequestMapping(value="/Teacherinsert", method= RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String Teacherinsert(HttpServletRequest request) {
        //插入数据库
        String TnameString = request.getParameter("Tname");
        String passwordString = request.getParameter("password");
        String numberString = request.getParameter("number");
        String classnumString = request.getParameter("classnum");
        String phonenumberString = request.getParameter("phonenumber");
        String typeString = request.getParameter("type");
        Integer phonenumberInteger = Integer.valueOf(phonenumberString);

        Teacher teacher = new Teacher();
        teacher.setTname(TnameString);
        teacher.setPassword(passwordString);
        teacher.setNumber(numberString);
        teacher.setClassnum(classnumString);
        teacher.setPhonenumber(phonenumberInteger);
        teacher.setType(typeString);
        teacherService.insert(teacher);
        //给前台返回的东西
        String data = "{\"data\":\"返回成功\"}";
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/TeacherdeleteById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String TeacherdeleteById(HttpServletRequest request) {
        //插入数据库
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        teacherService.deleteById(idInteger);
        //给前台返回的东西
        String data = "{\"data\":\"删除成功\"}";
        return data;
    }

    @ResponseBody    //返回字符串   修改
    @RequestMapping(value="/Teacherupdate", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String Teacherupdate(HttpServletRequest request) {

        String idString = request.getParameter("id");
        String TnameString = request.getParameter("Tname");
        String passwordString = request.getParameter("password");
        String numberString = request.getParameter("number");
        String classnumString = request.getParameter("classnum");
        String phonenumberString = request.getParameter("phonenumber");
        String typeString = request.getParameter("type");
        Integer idInteger = Integer.valueOf(idString);
        Integer phonenumberInteger = Integer.valueOf(phonenumberString);

        Teacher teacher = new Teacher();
        teacher.setId(idInteger);
        teacher.setTname(TnameString);
        teacher.setPassword(passwordString);
        teacher.setNumber(numberString);
        teacher.setClassnum(classnumString);
        teacher.setPhonenumber(phonenumberInteger);
        teacher.setType(typeString);
        teacherService.update(teacher);
        //给前台返回的东西
        String data = "{\"data\":\"返回成功\"}";
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/TeacherselectAll", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String TeacherselectAll(HttpServletRequest request) throws Exception {

        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        List<Teacher> teachers = teacherService.selectAll(pageInteger, limitInteger);
        System.out.println(teachers.toString());
        String[] colums = {"id","Tname","password","number","classnum","phonenumber","type"};
        String jsonString = ObjtoLayJson.ListtoJson(teachers, colums);
        return jsonString;
    }
    @ResponseBody
    @RequestMapping(value = "/TeacherSelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String TeacherSelectCount(HttpServletRequest request) {
        int count = teacherService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }
    @ResponseBody          //插入学生信息接口
    @RequestMapping(value="/insert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String insert(HttpServletRequest request) {
        //插入数据库
        String SnameString = request.getParameter("Sname");
        String passwordString = request.getParameter("password");
        String numberString = request.getParameter("number");
        String classnumString = request.getParameter("classnum");
        String TnameString = request.getParameter("Tname");
        String phonenumberString = request.getParameter("phonenumber");
        String typeString = request.getParameter("type");
        Integer phonenumberInteger = Integer.valueOf(phonenumberString);
        Integer typeInteger = Integer.valueOf(typeString);
        Student student = new Student();
        student.setSname(SnameString);
        student.setPassword(passwordString);
        student.setNumber(numberString);
        student.setClassnum(classnumString);
        student.setTname(TnameString);
        student.setPhonenumber(phonenumberInteger);
        student.setType(typeInteger);
        studentService.insert(student);
        //给前台返回的东西
        String data = "{\"data\":\"返回成功\"}";
        return data;
    }

    @ResponseBody          //删除学生信息接口
    @RequestMapping(value="/deleteById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String deleteById(HttpServletRequest request) {
        //插入数据库
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        studentService.deleteById(idInteger);
        //给前台返回的东西
        String data = "{\"data\":\"删除成功\"}";
        return data;
    }

    @ResponseBody              //修改学生信息接口
    @RequestMapping(value="/update", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String update(HttpServletRequest request) {
        String idString = request.getParameter("id");
        String SnameString = request.getParameter("Sname");
        String passwordString = request.getParameter("password");
        String numberString = request.getParameter("number");
        String classnumString = request.getParameter("classnum");
        String TnameString = request.getParameter("Tname");
        String phonenumberString = request.getParameter("phonenumber");
        String typeString = request.getParameter("type");
        Integer idInteger = Integer.valueOf(idString);
        Integer phonenumberInteger = Integer.valueOf(phonenumberString);
        Integer typeInteger = Integer.valueOf(typeString);
        Student student = new Student();
        student.setId(idInteger);
        student.setSname(SnameString);
        student.setPassword(passwordString);
        student.setNumber(numberString);
        student.setClassnum(classnumString);
        student.setTname(TnameString);
        student.setPhonenumber(phonenumberInteger);
        student.setType(typeInteger);
        studentService.update(student);
        //给前台返回的东西
        String data = "{\"data\":\"返回成功\"}";
        return data;
    }

    @ResponseBody          //查询学生信息接口
    @RequestMapping(value="/selectAll", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String selectAll(HttpServletRequest request) throws Exception {

        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        List<Student> students = studentService.selectAll(pageInteger, limitInteger);
        System.out.println(students.toString());
        String[] colums = {"id","Sname","Tname","password","number","classnum","phonenumber","type"};
        String jsonString = ObjtoLayJson.ListtoJson(students, colums);
        return jsonString;
    }


    @ResponseBody
    @RequestMapping(value = "/StudentSelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String StudentSelectCount(HttpServletRequest request) {
        int count = studentService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

    @ResponseBody           //课程视频搜索接口
    @RequestMapping(value="/videoselect", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String videoselect(HttpServletRequest request) throws Exception {

        String videonameString = request.getParameter("videoname");
        Student student = studentService.videoselect(videonameString);
        String[] colums = {"id","videoname","content","author"};
        String data = ObjtoLayJson.toJson(student, colums);
        System.out.println(data);
        return data;
    }

    @ResponseBody          //学生参加讨论话题接口
    @RequestMapping(value="/discussinsert", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String discussinsert(HttpServletRequest request) {
        String idString = request.getParameter("id");
        String titleString = request.getParameter("title");
        String authorString = request.getParameter("author");
        String heatString = request.getParameter("heat");
        String numberString = request.getParameter("number");
        String replyString = request.getParameter("reply");
        Integer idInteger = Integer.valueOf(idString);
        Integer heatInteger = Integer.valueOf(heatString);
        Discuss discuss = new Discuss();
        discuss.setId(idInteger);
        discuss.setTitle(titleString);
        discuss.setAuthor(authorString);
        discuss.setHeat(heatInteger);
        discuss.setNumber(numberString);
        discuss.setReply(replyString);
        studentService.discussinsert(discuss);
        //给前台返回的东西
        String data = "{\"data\":\"返回成功\"}";
        return data;
    }


    @ResponseBody         //学生作业展示接口
    @RequestMapping(value="/taskselect", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String taskselect(HttpServletRequest request) throws Exception {

        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        List<Task> tasks = studentService.taskselect(pageInteger, limitInteger);
        System.out.println(tasks.toString());
        String[] colums = {"id","tasktitle","content","status","Sname","number","classnum","grade"};
        String jsonString = ObjtoLayJson.ListtoJson(tasks, colums);
        return jsonString;
    }
    @ResponseBody
    @RequestMapping(value = "/taskSelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String taskSelectCount(HttpServletRequest request) {
        int count = studentService.taskSelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }
    @ResponseBody              //修改学生信息接口
    @RequestMapping(value="/taskupdate", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String taskupdate(HttpServletRequest request) {
        HttpSession session=request.getSession();
        String number=(String)session.getAttribute("number");
        String idString = request.getParameter("id");
        String tasktitleString = request.getParameter("tasktitle");
        String contentString = request.getParameter("content");
        Integer idInteger = Integer.valueOf(idString);
        Task task = new Task();



        Student student=studentService.selectById(number);

        task.setId(idInteger);
        task.setNumber(number);
        task.setId(idInteger);
        task.setClassnum(student.getClassnum());
        task.setSname(student.getSname());
        task.setStatus(1);
        task.setTasktitle(tasktitleString);
        task.setContent(contentString);
        studentService.taskupdate(task);
        //给前台返回的东西
        String data = "{\"data\":\"返回成功\"}";
        return data;
    }

    @ResponseBody          //课题讨论显示接口
    @RequestMapping(value="/discussselect", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String discussselect(HttpServletRequest request) throws Exception {

        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        List<Discuss> discusss = studentService.discussselect(pageInteger, limitInteger);
        System.out.println(discusss.toString());
        String[] colums = {"id","title","author","heat","number","reply"};
        String jsonString = ObjtoLayJson.ListtoJson(discusss, colums);
        return jsonString;
    }
    @ResponseBody
    @RequestMapping(value = "/discussSelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String discussSelectCount(HttpServletRequest request) {
        int count = studentService.discussSelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }

}
