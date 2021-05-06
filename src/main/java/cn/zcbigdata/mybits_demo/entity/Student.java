package cn.zcbigdata.mybits_demo.entity;

public class Student {
    private Integer id;
    private String Sname;
    private String password;
    private String number;
    private String classnum;
    private String Tname;
    private int phonenumber;
    private int type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Sname='" + Sname + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", classnum='" + classnum + '\'' +
                ", Tname='" + Tname + '\'' +
                ", phonenumber=" + phonenumber +
                ", type=" + type +
                '}';
    }
}
