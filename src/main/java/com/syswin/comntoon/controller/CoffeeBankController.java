package com.syswin.comntoon.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syswin.comntoon.model.Card;
import com.syswin.comntoon.model.CustomCard;
import com.syswin.comntoon.model.Task;
import com.syswin.comntoon.service.impl.CardService;
import com.syswin.comntoon.service.impl.CustomCardService;
import com.syswin.comntoon.service.impl.TaskService;

@RestController
@ComponentScan({"com.syswin.comntoon.service"})
@MapperScan("com.syswin.comntoon.mapper")
public class CoffeeBankController {
	@Resource
    private CustomCardService customCardService;
	@Resource
    private TaskService taskService;
	@Resource
    private CardService cardService;
    
    @RequestMapping("/findcustom")
    public CustomCard findcustom(@RequestBody Map<String,Object> map){
    	String customcard = (String)map.get("customcard");
    	CustomCard custom =  customCardService.find(customcard);
        return custom;
    }
    
    
    @RequestMapping("/findtask")
    public List<Task> findtask(){
    	List<Task> task =  taskService.find();
        return task;
    }
    
    
    @RequestMapping("/findtaskbyresult")
    public List<Task> findtaskbyresult(@RequestBody Map<String,Object> map){
    	String result = (String)map.get("result");
    	List<Task> task =  taskService.findbyresult(result);
        return task;
    }
    
    @RequestMapping("/findtaskbyid")
    public Task findtaskbyid(@RequestBody Map<String,Object> map){
    	int id = (int)map.get("id");
    	Task task =  taskService.findbyid(id);
        return task;
    }
    
    
    @RequestMapping("/updatetask")
    public void updatetask(@RequestBody Task task){
    	taskService.update(task);
    }
    
    @RequestMapping("/deletetask")
    public void deletetask(@RequestBody Map<String,Object> map){
    	String id = (String)map.get("id");
    	taskService.delete(Integer.valueOf(id));
    }
    
    
    @RequestMapping("/inserttask")
    public int inserttask(@RequestBody Task task){
    	 taskService.insert(task);
    	 int id = task.getId();
    	 return id;
    }
    
    @RequestMapping("/querycardyue")
    public Card querycardyue(@RequestBody Map<String,Object> map){
    	String cardno = (String)map.get("cardno");
    	Card card=  cardService.find(cardno);
        return card;
    }
    
    
}
