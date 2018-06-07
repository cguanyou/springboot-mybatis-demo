package com.syswin.comntoon.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.syswin.comntoon.model.Task;

@Mapper
public interface TaskMapper {
    public int insert(Task task);

    public void update(Task task);
    
    public void delete(int id);
    
    public List<Task> find();

    public List<Task> findbyresult(String result);
    
    public Task findbyid(int id);
}
