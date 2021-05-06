package cn.zcbigdata.mybits_demo.mapper;



import cn.zcbigdata.mybits_demo.entity.Video;

import java.util.List;

public interface FilepathMapper {
    int insert(String path);

    List<Video> showFiles();
}