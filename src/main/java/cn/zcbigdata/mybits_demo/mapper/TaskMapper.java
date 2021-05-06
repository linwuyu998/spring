package cn.zcbigdata.mybits_demo.mapper;

import cn.zcbigdata.mybits_demo.entity.Task;

import java.util.List;

public interface TaskMapper {

    int SelectCount();

    List<Task> selectAll(int pageIndex, int pageSize);
    int insert(Task task);
    int update(Task task);
}
