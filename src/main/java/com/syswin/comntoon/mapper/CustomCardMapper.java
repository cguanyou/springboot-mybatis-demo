package com.syswin.comntoon.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.syswin.comntoon.model.CustomCard;

@Mapper
public interface CustomCardMapper {
    public void insert(CustomCard customCard);

    public void update(CustomCard customCard);
    
    public void delete(String id);
    
    public CustomCard find(String id);
}
