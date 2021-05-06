package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Discuss;
import cn.zcbigdata.mybits_demo.mapper.DiscussMapper;
import cn.zcbigdata.mybits_demo.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussServiceImpl implements DiscussService {
    @Autowired
    private DiscussMapper discussMapper;



    @Override
    public int SelectCount() {
        return this.discussMapper.SelectCount();
    }

    @Override
    public List<Discuss> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.discussMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int insert(Discuss discuss) {
        return this.discussMapper.insert(discuss);
    }

    @Override
    public int DiscussdeleteById(int id) {
        return this.discussMapper.DiscussdeleteById(id);
    }
}
