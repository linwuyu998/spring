package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Discuss;

import java.util.List;

public interface DiscussService {



    int SelectCount();

    List<Discuss> selectAll(int pageInteger, int limitInteger);

    int insert(Discuss discuss);

    int DiscussdeleteById(int id);
}
