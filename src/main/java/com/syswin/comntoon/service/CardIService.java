package com.syswin.comntoon.service;

import com.syswin.comntoon.model.Card;

public interface CardIService {
	public void insert(Card card);
	
    public void update(Card card);

    public Card find(String cardno);
  
    public void delete(String cardno);
}
