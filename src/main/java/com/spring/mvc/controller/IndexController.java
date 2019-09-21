/*
package com.spring.mvc.controller;


import com.spring.mvc.service.IndexService;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class IndexController {
    @Autowired
    private IndexService indexService;


    @RequestMapping(value="/excel",method= RequestMethod.GET)
    public String index(Model model) throws IOException, InvalidFormatException {


        List<Map> list2=indexService.findAll();
        System.out.println(list2);
        model.addAttribute("list2",list2);
        return "login_database";
    }

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login( ){

            return "login";

    }
    @RequestMapping(value="/tologin",method= RequestMethod.POST)
    public String tologin(HttpServletRequest request){
        String username=request.getParameter("username");

        String pwd=request.getParameter("pwd");
        System.out.println("login"+username+"||"+pwd);
        boolean flag=indexService.login(username,pwd);


        if(flag){
            return "redirect:/index/excel";

        }else{


            return "login";
        }


        }



    @RequestMapping(value="/zhuche",method= RequestMethod.GET)
    public String zhuce( ) {

        return "zhuche";

    }
    @RequestMapping(value="/dd",method= RequestMethod.GET)
    public String dd( ) {

        return "dd";

    }
    @RequestMapping(value="/tozhuche",method= RequestMethod.POST)
    public String tozhuche(HttpServletRequest request){
        String username=request.getParameter("username");
        String pwd=request.getParameter("pwd");

        String name=request.getParameter("name");

        String  sex=request.getParameter("sex");
        System.out.println(username+" "+pwd+" "+name+" "+sex);
        int insert=indexService.zhuche(username,pwd,name,sex);
        boolean b=indexService.getName(username);
        if(insert>0||b){
            return "redirect:/index/login";
        }else {
            System.out.println("注册失败");
            return "dd";
        }
        }


    @RequestMapping(value="/delete",method= RequestMethod.GET)
    public String delect(HttpServletRequest request){

        String id=request.getParameter("id");
        System.out.println(id);
        boolean b=indexService.delectById(Integer.parseInt(id));
        System.out.println(b);
        if(b){
            return "redirect:/index/excel";
        }else{
            return "login";
        }
    }
        @RequestMapping(value="/select",method= RequestMethod.GET)
        public String select(HttpServletRequest request, Model model) {
            String id=request.getParameter("id");
            System.out.println(id);
            List<Map> list=indexService.selectById(Integer.parseInt(id));
            model.addAttribute("list",list);
            System.out.println(list);



                return "select ";

        }
        @RequestMapping(value="/update",method= RequestMethod.GET)
        public String update(HttpServletRequest request, Model model) {

            String id=request.getParameter("id");
            Map map=indexService.findById(id);
            model.addAttribute("map", map);
            return "update";



        }
        @RequestMapping(value="/update1",method= RequestMethod.POST)
        public String update1(HttpServletRequest request, Model model) {

            String id=request.getParameter("id");
            String username=request.getParameter("username");
            String pwd=request.getParameter("pwd");

            String login_name=request.getParameter("login_name");

            String  sex=request.getParameter("sex");
//            System.out.println(username+" "+pwd+" "+name+" "+sex);
            boolean update=indexService.updateById(id,username,pwd,login_name,sex);
           if(update){
               return "redirect:/index/excel";

           }else{
               return "updateshibai";
           }
        }



}


*/









