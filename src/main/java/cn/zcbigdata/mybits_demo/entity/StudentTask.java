package cn.zcbigdata.mybits_demo.entity;

public class StudentTask {
    private int id;
    private String tasktitle;
    private String content;
    private int status;
    private String Sname;
    private String number;
    private String classnum;
    private int grade;
    private String Tname;
    private int phonenumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTasktitle() {
        return tasktitle;
    }

    public void setTasktitle(String tasktitle) {
        this.tasktitle = tasktitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "StudentTask{" +
                "id=" + id +
                ", tasktitle='" + tasktitle + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", Sname='" + Sname + '\'' +
                ", number='" + number + '\'' +
                ", classnum='" + classnum + '\'' +
                ", grade=" + grade +
                ", Tname='" + Tname + '\'' +
                ", phonenumber=" + phonenumber +
                '}';
    }
}
