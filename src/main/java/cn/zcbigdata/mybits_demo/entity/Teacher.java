package cn.zcbigdata.mybits_demo.entity;

public class Teacher {
    private Integer id;
    private String Tname;
    private String password;
    private String number;
    private String classnum;
    private int phonenumber;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
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

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", Tname='" + Tname + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", classnum='" + classnum + '\'' +
                ", phonenumber=" + phonenumber +
                ", type='" + type + '\'' +
                '}';
    }
}
