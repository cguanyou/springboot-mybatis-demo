package com.syswin.comntoon.service.impl;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.syswin.comntoon.mapper.CardMapper;
import com.syswin.comntoon.model.Card;
import com.syswin.comntoon.service.CardIService;
@ComponentScan({"com.syswin.comntoon.mapper"})
@Service("cardService")
public class CardService implements CardIService {
	@Resource
    private CardMapper cardMapper;

	@Override
	public void insert(Card card) {
		cardMapper.insert(card);
		
	}

	@Override
	public void update(Card card) {
		cardMapper.update(card);
		
	}

	@Override
	public Card find(String cardno) {
		// TODO Auto-generated method stub
		return cardMapper.find(cardno);
	}

	@Override
	public void delete(String cardno) {
		cardMapper.delete(cardno);
		
	}

}
