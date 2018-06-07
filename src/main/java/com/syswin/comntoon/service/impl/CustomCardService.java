package com.syswin.comntoon.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.syswin.comntoon.mapper.CustomCardMapper;
import com.syswin.comntoon.model.CustomCard;
import com.syswin.comntoon.service.CustomCardIService;
@ComponentScan({"com.syswin.comntoon.mapper"})
@Service("customCardService")
public class CustomCardService implements CustomCardIService {
	@Resource
    private CustomCardMapper customCardMapper;

	@Override
	public void insert(CustomCard customCard) {
		customCardMapper.insert(customCard);
		
	}

	@Override
	public void update(CustomCard customCard) {
		customCardMapper.update(customCard);
		
	}

	@Override
	public CustomCard find(String id) {
		// TODO Auto-generated method stub
		return customCardMapper.find(id);
	}

	@Override
	public void delete(String id) {
		customCardMapper.delete(id);
		
	}

}
