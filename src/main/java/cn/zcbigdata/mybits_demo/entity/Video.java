package cn.zcbigdata.mybits_demo.entity;

public class Video {
    private int id;
    private String filepath;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", filepath='" + filepath + '\'' +
                '}';
    }
}
