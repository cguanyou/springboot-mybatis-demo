package com.syswin.comntoon.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.syswin.comntoon.model.User;

@Mapper
public interface UserMapper {
    public void insert(User user);

    public void update(User user);
    
    public void delete(int id);
    
    public User find(int id);
}
