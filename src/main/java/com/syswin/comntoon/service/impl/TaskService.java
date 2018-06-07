package com.syswin.comntoon.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.syswin.comntoon.mapper.TaskMapper;
import com.syswin.comntoon.model.Task;
import com.syswin.comntoon.service.TaskIService;
@ComponentScan({"com.syswin.comntoon.mapper"})
@Service("taskService")
public class TaskService implements TaskIService {
	@Resource
    private TaskMapper taskMapper;

	@Override
	public int insert(Task task) {
		return taskMapper.insert(task);
		
	}

	@Override
	public void update(Task task) {
		taskMapper.update(task);
		
	}

	@Override
	public List<Task> find() {
		// TODO Auto-generated method stub
		return taskMapper.find();
	}

	@Override
	public void delete(int id) {
		taskMapper.delete(id);
		
	}

	@Override
	public Task findbyid(int id) {
		// TODO Auto-generated method stub
		return taskMapper.findbyid(id);
	}

	@Override
	public List<Task> findbyresult(String result) {
		// TODO Auto-generated method stub
		return taskMapper.findbyresult(result);
	}


}
