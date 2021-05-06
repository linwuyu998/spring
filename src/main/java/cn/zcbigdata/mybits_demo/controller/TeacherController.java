package cn.zcbigdata.mybits_demo.controller;

import cn.zcbigdata.mybits_demo.Util.ObjtoLayJson;
import cn.zcbigdata.mybits_demo.entity.Course;
import cn.zcbigdata.mybits_demo.entity.Discuss;
import cn.zcbigdata.mybits_demo.entity.StudentTask;
import cn.zcbigdata.mybits_demo.service.CourseService;
import cn.zcbigdata.mybits_demo.service.DiscussService;
import cn.zcbigdata.mybits_demo.service.StudentTaskService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/Teacher")
public class TeacherController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentTaskService studentTaskService;
    @Autowired
    private DiscussService discussService;
    @RequestMapping(value = "/CourseselectAll", method = RequestMethod.GET)
    @ResponseBody  //返回json类型的数据
    public String CourseselectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        List<Course> courses=courseService.selectAll(pageInteger,limitInteger);
        String[] colums = {"id","coursename","content","author"};
        String jsonString = ObjtoLayJson.ListtoJson(courses,colums);
        return jsonString;
    }
    //查询表中有稍等条数据
    @ResponseBody
    @RequestMapping(value = "/CourseSelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String CourseSelectCount(HttpServletRequest request) {
        int count = courseService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/Courseinsert", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String Courseinsert(HttpServletRequest request) {
        String coursename=request.getParameter("coursename");
        String content=request.getParameter("content");
        String author=request.getParameter("author");
        Course course=new Course();
        course.setAuthor(author);
        course.setCoursename(coursename);
        course.setContent(content);
        courseService.insert(course);
        String data = "{\"data\":\"添加密码成功\"}";
        return data;

    }
    @ResponseBody
    @RequestMapping(value ="selectByCoursename",method = RequestMethod.GET)
    public String selectByCoursename(HttpServletRequest request) throws Exception{
        String coursename=request.getParameter("coursename");
        Course course=courseService.selectByCoursename(coursename);
        System.out.println(course);

        String[] colums = {"id","coursename","content","author"};
        String data = ObjtoLayJson.toJson(course, colums);
        System.out.println(data);
        return data;
    }

    @RequestMapping(value = "/TaskselectAll", method = RequestMethod.GET)
    @ResponseBody  //返回json类型的数据
    public String TaskselectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);

        List<StudentTask> studentTasks=studentTaskService.selectAll(pageInteger,limitInteger);

        String[] colums = {"id","tasktitle","content","status","Sname","number","classnum","grade","Tname","phonenumber"};
        String jsonString = ObjtoLayJson.ListtoJson(studentTasks,colums);
        return jsonString;
    }

    //查询表中有稍等条数据
    @ResponseBody
    @RequestMapping(value = "/TaskSelectCount", method = RequestMethod.GET, produces = "text/plain;charset=utf-8")
    public String TaskSelectCount(HttpServletRequest request) {
        int count = studentTaskService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }
    @ResponseBody
    @RequestMapping(value = "/Taskinsert",method = RequestMethod.GET)
    public String Taskinsert(HttpServletRequest request){
        String tasktitleString=request.getParameter("tasktitle");
        String contentString=request.getParameter("content");
        // String statusString=request.getParameter("status");
        // String SnameString=request.getParameter("Sname");
        //String numberString=request.getParameter("number");
        //String classnumString=request.getParameter("classnum");
        // String gradeString=request.getParameter("grade");
        //Integer statusInteger=Integer.valueOf(statusString);
        //Integer gradeInteger=Integer.valueOf(gradeString);
        StudentTask studentTask=new StudentTask();
        studentTask.setContent(contentString);
        studentTask.setTasktitle(tasktitleString);
        studentTaskService.insert(studentTask);
        String data = "{\"data\":\"添加密码成功\"}";
        return data;

    }
    @ResponseBody
    @RequestMapping(value="/Taskupdate",method = RequestMethod.GET)
    public String Taskupdate(HttpServletRequest request){
        String idString=request.getParameter("id");
        String tasktitleString=request.getParameter("tasktitle");
        String contentString=request.getParameter("content");
        String gradeString=request.getParameter("grade");
        Integer gradeInteger=Integer.valueOf(gradeString);
        Integer idInteger=Integer.valueOf(idString);
        StudentTask studentTask=new StudentTask();
        studentTask.setId(idInteger);
        studentTask.setGrade(gradeInteger);
        studentTask.setTasktitle(tasktitleString);
        studentTask.setContent(contentString);
        studentTaskService.update(studentTask);
        String data = "{\"data\":\"添加密码成功\"}";
        return data;

    }
    @ResponseBody    //返回字符串   根据id删除
    @RequestMapping(value="/TaskdeleteById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")  //访问路径 方法 字符集
    public String TaskdeleteById(HttpServletRequest request) throws Exception{

        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        studentTaskService.deleteById(idInteger);
        String data = "{\"data\":\"删除成功\"}";
        return data;
    }

    @RequestMapping(value = "/DiscussselectAll", method = RequestMethod.GET)
    @ResponseBody  //返回json类型的数据
    public String DiscussselectAll(HttpServletRequest request) throws Exception{
        String pageString = request.getParameter("page");
        String limitString = request.getParameter("limit");
        Integer pageInteger = Integer.valueOf(pageString);
        Integer limitInteger = Integer.valueOf(limitString);
        System.out.println(pageString + limitString);
        List<Discuss> disscussions=discussService.selectAll(pageInteger,limitInteger);
        String[] colums={"id","title","author","heat","number","reply"};
        String jsonString = ObjtoLayJson.ListtoJson(disscussions,colums);
        return jsonString;
    }
    @RequestMapping(value = "/DiscussSelectCount", method = RequestMethod.GET)
    @ResponseBody  //返回json类型的数据
    public String DiscussSelectCount(HttpServletRequest request){
        int count=discussService.SelectCount();
        System.out.println( "count:" + count );
        String data = String.valueOf(count);
        String json= "{"+"\"count\":"+data+"}";
        return json;
    }
    @RequestMapping(value = "/Discussinsert", method = RequestMethod.GET)
    @ResponseBody  //返回json类型的数据
    public String Discussinsert(HttpServletRequest request){
        String titleString=request.getParameter("title");
        String authorString=request.getParameter("author");
        String heatString=request.getParameter("heat");
        String numberString=request.getParameter("number");
        String replyString=request.getParameter("reply");
        Integer heatInteger=Integer.valueOf(heatString);
        Discuss discuss=new Discuss();
        discuss.setAuthor(authorString);
        discuss.setNumber(numberString);
        discuss.setHeat(heatInteger);
        discuss.setTitle(titleString);
        discuss.setReply(replyString);
        discussService.insert(discuss);
        String data = "{\"data\":\"添加密码成功\"}";
        return data;


    }

    @ResponseBody          //删除学生信息接口
    @RequestMapping(value="/DiscussdeleteById", method=RequestMethod.GET,produces = "text/plain;charset=utf-8")
    public String DiscussdeleteById(HttpServletRequest request) {
        //插入数据库
        String idString = request.getParameter("id");
        Integer idInteger = Integer.valueOf(idString);
        discussService.DiscussdeleteById(idInteger);
        //给前台返回的东西
        String data = "{\"data\":\"删除成功\"}";
        return data;
    }



}


