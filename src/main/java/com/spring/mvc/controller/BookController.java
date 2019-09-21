package com.spring.mvc.controller;


import com.spring.mvc.service.BookService;
import com.spring.mvc.service.LoginAndUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;


@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private LoginAndUserService loginAndUserService;

    @RequestMapping(value = "/showbook",method = RequestMethod.GET)
    public String  showbook(Model model) {
        List<Map> list3 = bookService.findAllBook();
        model.addAttribute("list3", list3);

        return  "book";
    }

    @RequestMapping(value = "/bookbase",method = RequestMethod.GET)
    public String  bookbase(@RequestParam("name") String name, Model model) {


            List<Map> list =bookService.bookbase(name);
            model.addAttribute("list", list);



            return  "bookbase";
    }
    @RequestMapping(value = "/showAll",method = RequestMethod.GET)
    public String  showAll(@RequestParam("bid") String bid, Model model) {

        System.out.println("bid-->"+bid);
            Map showall =bookService.showAll(bid);
            model.addAttribute("showall", showall);

            return  "showBookAndUser";
    }
    @RequestMapping(value = "/borrow",method = RequestMethod.GET)
    public String  borrow(HttpServletRequest request, Model model) {
        String bid=request.getParameter("bid");


        System.out.println("bid-->"+bid);
        List<Map> showuser = loginAndUserService.findAllUser();
        System.out.println(showuser);
        model.addAttribute("showuser", showuser);
        model.addAttribute("bid",bid);


        return  "borrow";
    }
    @RequestMapping(value = "/borrowbook",method = RequestMethod.GET)
    public String  borrowbook(HttpServletRequest request, Model model) {
        String bid=request.getParameter("bid");
        String sta=request.getParameter("sta");
        if(request.getParameter("cid")=="0") {
            String cid = "1";
            int borrowbook = bookService.borrowbook(sta,bid,cid);
        }


        return  "success";
    }





}
