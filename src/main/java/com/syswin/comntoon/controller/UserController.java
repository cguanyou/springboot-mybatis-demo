package com.syswin.comntoon.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.syswin.comntoon.model.User;
import com.syswin.comntoon.service.impl.CustomCardService;
import com.syswin.comntoon.service.impl.UserService;

@RestController
@ComponentScan({"com.syswin.comntoon.service"})
@MapperScan("com.syswin.comntoon.mapper")
public class UserController {
	@Resource
    private CustomCardService customCardService;
	@Resource
    private UserService userService;
    
     @RequestMapping("/say")  
     public String say(){  
         return "springboot-a"+userService;
     }  
    
    @RequestMapping("/find")
    public String find(@RequestBody Map<String,Object> map){
    	System.out.println(map.get("a"));
        User user =  userService.find(1);
        ModelAndView mav = new ModelAndView();
        mav.addObject("user","sadf");
        return "HelloWord"+"fasdf--"+user.getUsername()+"--"+user.getPassword();
    }
    
    
    @RequestMapping("/ajax")
    public String find1(){
        return "[''message':'123dfx']";
    }
    
    
//    @RequestMapping("/findcustom")
//    public String findcustom(@RequestBody Map<String,Object> map){
//    	String customcard = (String)map.get("customcard");
//    	CustomCard custom =  customCardService.find(customcard);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("customcard","sadf");
//        return "HelloWord"+"fasdf--"+custom.getCardnum()+"--"+custom.getCheckresult();
//    }
    
}
