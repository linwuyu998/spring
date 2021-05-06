package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Discuss;

import java.util.List;

public interface DiscussMapper {

    int SelectCount();

    List<Discuss> selectAll(int pageIndex, int pageSize);
    int insert(Discuss discuss);
    int DiscussdeleteById(int id);
}
