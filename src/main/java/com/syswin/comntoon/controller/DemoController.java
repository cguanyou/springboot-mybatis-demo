package com.syswin.comntoon.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.syswin.comntoon.model.CustomCard;
import com.syswin.comntoon.service.impl.CustomCardService;
@Controller
@ComponentScan({"com.syswin.comntoon.service"})
@MapperScan("com.syswin.comntoon.mapper")
public class DemoController {
	@Resource
    private CustomCardService customCardService;
    @RequestMapping("/coffeebank")
    public String helloHtml(HashMap<String, Object> map) {
        map.put("coffee", "欢迎进入咖啡银行启动页面"+"jenkinstest！！！！！！");
        return "/comntoon/coffeebankdemo/coffeebankindex";
    }
    
    @RequestMapping("/tasklist")
    public String tasklist() {
        return "/comntoon/coffeebankdemo/tasklist";
    }
    
    
//    @RequestMapping("/findcustom")
//    public String find(@RequestBody Map<String,Object> map){
//    	String customcard = (String)map.get("customcard");
//    	CustomCard custom =  customCardService.find(customcard);
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("customcard","sadf");
//        return "HelloWord"+"fasdf--"+custom.getCardnum()+"--"+custom.getCheckresult();
//    }
    
    
}
