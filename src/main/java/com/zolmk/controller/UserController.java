package com.zolmk.controller;

import com.alibaba.fastjson.JSON;
import com.zolmk.entity.User;
import com.zolmk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/login/{name}/{password}/commit")
    @ResponseBody
    public Map<String, String> login(@PathVariable String name, @PathVariable String password){
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("passwd",password);
        return map;
    }
    @RequestMapping("/list")
    @ResponseBody
    public List<User> list(){
        List<User> users = userService.list();
        System.out.println(users.size());
        return users;
    }
}
