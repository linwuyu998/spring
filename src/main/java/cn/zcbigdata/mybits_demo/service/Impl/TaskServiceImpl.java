package cn.zcbigdata.mybits_demo.service.Impl;

import cn.zcbigdata.mybits_demo.entity.Task;
import cn.zcbigdata.mybits_demo.mapper.TaskMapper;
import cn.zcbigdata.mybits_demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;



    @Override
    public int SelectCount() {
        return this.taskMapper.SelectCount();
    }

    @Override
    public List<Task> selectAll(int pageInteger, int limitInteger) {
        int pageIndex = (pageInteger-1) * limitInteger;
        int pageSize = limitInteger;
        return this.taskMapper.selectAll(pageIndex,pageSize);
    }

    @Override
    public int insert(Task task) {
        return this.taskMapper.insert(task);
    }

    @Override
    public int update(Task task) {
        return this.taskMapper.update(task);
    }
}
