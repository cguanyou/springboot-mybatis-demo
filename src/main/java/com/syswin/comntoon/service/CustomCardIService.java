package com.syswin.comntoon.service;

import com.syswin.comntoon.model.CustomCard;

public interface CustomCardIService {
	public void insert(CustomCard customCard);
	
    public void update(CustomCard customCard);

    public CustomCard find(String id);
  
    public void delete(String id);
}
