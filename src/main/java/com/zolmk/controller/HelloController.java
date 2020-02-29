package com.zolmk.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 用来做参考
 */
@Controller
public class HelloController{
    @RequestMapping("/hello")
    public ModelAndView hello(HttpServletRequest req, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","hello springmvc");
        mv.setViewName("hello");
        return mv;
    }
    @RequestMapping("/hello1")
    public void chechUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.jsp");
    }
    // post get 参数获取
    @RequestMapping("/hello2")
    public void hello(@RequestParam("id")int id){

    }
    // 路径变量获取
    @RequestMapping("/hello/{username}/{email}/{phonenumber}/{passwd}/do")
    public String path(@PathVariable(value = "username") String username, @PathVariable String email, @PathVariable String phonenumber,@PathVariable String passwd){
        System.out.println("UserName:"+username+"\temail:"+email+"\tphonenumber:"+phonenumber+"\tpassword:"+passwd);
        return "hello";
    }
    // 返回json数据
    @RequestMapping("/hello/{name}/{password}/commit")
    @ResponseBody
    public String login(@PathVariable String name, @PathVariable String password){
        Map<String,String> map = new HashMap<>();
        map.put(name,password);
        return JSON.toJSONString(map);
    }
    //单文件上传
    @RequestMapping("/hello/upload")
    public String fileupload(@RequestParam(value = "file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
        //获取文件名
        //file.getOriginalFilename();
        //获取路径
        String path = request.getRealPath("/fileupload");
        saveFile(file,path);

        return "/index.jsp";
    }
    //多文件上传
    @RequestMapping("/hello/batchupload")
    public String batchFileUpload(@RequestParam(value = "file") CommonsMultipartFile[] file, HttpServletRequest request) throws IOException {
        //获取文件名
        //file.getOriginalFilename();
        //获取路径
        String path = request.getRealPath("/fileupload");
        for (CommonsMultipartFile f :
                file) {
            saveFile(f,path);
        }
        return "/index.jsp";
    }
    private void saveFile(CommonsMultipartFile f,String path) throws IOException {
        InputStream is = f.getInputStream();
        OutputStream os = new FileOutputStream(new File(path,f.getOriginalFilename()));
        int len = 0;
        byte[] buffer = new byte[400];
        while((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        os.close();
        is.close();
    }


}
