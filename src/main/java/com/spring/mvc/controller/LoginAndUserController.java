package com.spring.mvc.controller;


import com.spring.mvc.service.BookService;
import com.spring.mvc.service.LoginAndUserService;
import com.spring.mvc.service.LoginLoggingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginAndUserController {
    @Autowired
    private LoginAndUserService loginService;

    @Autowired
    private BookService bookService;
    @Autowired
    private LoginLoggingsService loginLoggingsService;








    @ExceptionHandler({ArithmeticException.class})

    public ModelAndView handlerArithmeticException(Exception ex) {
        System.out.println("----出异常了" + ex);
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        return mv;
    }



    /*错误处理*/
    /*在方法如此那中可以加入exception类型的参数1 参数对应发生的类型异常对象
    *exceptionhandler 方法的入参不能传入Map  若希望把异常信息传入到页面需要modelandview作为返回值 */

    @RequestMapping("/testExceptionResolver")

    public String  testExceptionResolver (@RequestParam("i") int i){
        System.out.println("testExceptionResolver" +(10/i));
    return  "exception";
    }


    /*登录页面*/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {

        return "login";

    }
    /*判断是否登录*/
    @RequestMapping(value = "/tologin", method = RequestMethod.POST)
    public String tologin(HttpServletRequest request,Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean flag = loginService.login(username, password);
        if (username != "" && password != "" && flag) {

           model.addAttribute("username",username);
           return "menu";
        } else {
            return "login";
        }
    }
    /*注册页面*/
    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(){
        return   "register";
    }
    /*判断注册是否成功*/
    @RequestMapping(value = "/toregister",method = RequestMethod.POST)
    public String toregister(
            @RequestParam("name") String name,
            @RequestParam("gender") String gender,
            @RequestParam("email") String email,
            @RequestParam("age") String age,
            @RequestParam("username") String username,
            @RequestParam("password") String password) {

        boolean fname=loginService.findByName(username);



        System.out.println(fname);
        if (!fname&&name!=""&&age!=""&&password!=""&&username!=""&&email!=""&&gender!="") {
            loginService.register(name, username, password, age, gender, email);
            return "redirect:/login";
        } else {
            return "register";
        }
    }




    /*书籍查找页面*/

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public String book(Model model) {

        List<Map> list1=bookService.findAllBook();
        model.addAttribute("list1",list1);


        return "showbook";
    }

    /*查看书籍详情*/
    @RequestMapping(value = "/findbook",method = RequestMethod.GET)
    public String findbook(@RequestParam(value = "name") String name, HttpServletRequest request, Model model){

        /*获取参数 id 和 借阅参数*/


        /*查找书籍的信息*/
        Map showbook=loginService.findBookByName(name);
        model.addAttribute("showbook",showbook)

        ;
        List<Map> list=bookService.findBookByName(name);
        model.addAttribute("list",list);


        /*统计书籍的*/
        int count= loginService.allBooks(name);
        model.addAttribute("count",count);

        int other=loginService.othersBooks(name);
        model.addAttribute("other",other);

        return  "yourbook";


    }





    /*用户列表页面*/
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {


        List<Map> list2 = loginService.findAllUser();
        System.out.println(list2);
        model.addAttribute("list2", list2);
        return "showuser";
    }

    /*用户更新信息页面*/
    @RequestMapping(value = "/toupdate",method = RequestMethod.GET)
    public String update(@RequestParam("id") String id,Model model){

        Map map=  loginService.findById(id);
        model.addAttribute("map", map);
        return "updateuser";
    }

    /*判断用户是否更新进行跳转*/
    @RequestMapping(value ="/userupdate", method = RequestMethod.POST)
    public String userupdate(@RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("gender") String gender, @RequestParam("email") String email, @RequestParam("age") String age, @RequestParam("username") String username, @RequestParam("password") String password) {
        boolean flag = loginService.updateUser(id, name,username , password, age, gender, email);
        System.out.println(flag);
        if (flag) {
            return "redirect:/user";
        }
            return "updateuser";
    }

    /*用户删除*/
    @RequestMapping(value = "/deleteuser",method = RequestMethod.GET)
    public String deleteuser(@RequestParam("id") String id){
        boolean flag=loginService.deleteuser(id);
        if (flag){
        return   "redirect:/user";
        }
        else {
            return   "redirect:/user";

        }

    }


    @RequestMapping(value = "loginLogging",method = RequestMethod.GET)
    public  String  loginLogging(@RequestParam("username") String username,Model model){
        if(loginLoggingsService.exists(username)){
        List<String> list=loginLoggingsService.InputStream(username);
        model.addAttribute("list",list);
        return "loginLogging";
        }else {
            return  "noLoginLogging";
        }

    }

}





