package cn.zcbigdata.mybits_demo.service;

import cn.zcbigdata.mybits_demo.entity.Task;

import java.util.List;

public interface TaskService {


    int SelectCount();

    List<Task> selectAll(int pageInteger, int limitInteger);

    int insert(Task task);

    int update(Task task);
}
