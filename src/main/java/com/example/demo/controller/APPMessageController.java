package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.AppMessage;
import com.example.demo.service.AppMessageService;
@RestController
@RequestMapping("/appmessage")
public class APPMessageController {
    @Autowired
    private AppMessageService service;
    @RequestMapping("/getThree")
    public List<AppMessage> getThreeForMessage(){
        
        List<AppMessage> list = service.getMessage();        
        return list;
    }

    @RequestMapping("/getAll")
    public List<AppMessage> getAllMessage(){
        
        List<AppMessage> list = service.getAllMessage();
        int num = list.size();
        if(null!=list && num>3){
            for (int i = 0; i < num-3; i++) {
                list.remove(0);
            }
        }
        return list;
    }
    @RequestMapping("/getByID")
    public List<AppMessage> getMessageById(@RequestParam("id") String id){
        List<AppMessage> list = service.getMessageById(id);
        int num = list.size();
        if(null!=list && num>5){
            for (int i = 0; i < num-5; i++) {
                list.remove(0);
            }
        }
        return list;
    }
    
    @RequestMapping(value = "/add",method = RequestMethod.POST) // 或者采用@PostMapping("/add")方法，更加节省代码的编写量
    public int addMessage(@RequestBody AppMessage appMessage){
        return service.addMessage(appMessage);
    }
    
    @RequestMapping(value="/delMessageById",method=RequestMethod.POST) // 或者采用@PostMapping("/delMessageById")方法，更加节省代码的编写量
    public int delMessageById(@RequestParam("id") String id){
            return service.delMessage(id);
    }
}