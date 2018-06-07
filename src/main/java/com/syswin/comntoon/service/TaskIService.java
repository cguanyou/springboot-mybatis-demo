package com.syswin.comntoon.service;

import java.util.List;

import com.syswin.comntoon.model.Task;

public interface TaskIService {
	public int insert(Task task);
	
    public void update(Task task);

    public List<Task> find();
    
    public Task findbyid(int id);
  
    public void delete(int id);
    
    public List<Task> findbyresult(String result);
}
