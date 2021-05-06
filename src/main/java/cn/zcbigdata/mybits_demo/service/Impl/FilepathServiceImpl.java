package cn.zcbigdata.mybits_demo.service.Impl;


import cn.zcbigdata.mybits_demo.entity.Video;
import cn.zcbigdata.mybits_demo.mapper.FilepathMapper;
import cn.zcbigdata.mybits_demo.service.FilepathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilepathServiceImpl implements FilepathService {
    @Autowired
    private FilepathMapper filepathMapper;


    @Override
    public int insert(String path) {
        return this.filepathMapper.insert(path);
    }

    @Override
    public List<Video> showFiles() {
        return this.filepathMapper.showFiles();
    }
}
