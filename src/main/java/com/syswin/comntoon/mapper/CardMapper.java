package com.syswin.comntoon.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.syswin.comntoon.model.Card;

@Mapper
public interface CardMapper {
    public void insert(Card card);

    public void update(Card card);
    
    public void delete(String cardno);
    
    public Card find(String cardno);
}
