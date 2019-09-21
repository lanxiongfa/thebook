package com.spring.mvc.service;

import com.spring.mvc.dao.BookDao;
import com.spring.mvc.dao.LoginAndUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginAndUserService {

    @Autowired
    private LoginAndUserDao loginDao;
    private BookDao bookDao;

    public boolean login(String C_USERNAME,String C_PASSWORD){
        Map map=new HashMap<>();
        map.put("C_USERNAME",C_USERNAME);
        map.put("C_PASSWORD",C_PASSWORD);
        return  loginDao.login(map).size()>0;
    }
    public List<Map> findAllBook(){

        return  loginDao.findAllBook();
    }
    public List<Map> findAllUser(){

        return  loginDao.findAllUser();
    }

    public boolean updateUser(String C_ID,String C_NAME,String C_USERNAME,String C_PASSWORD,String C_AGE,String GENDER,String C_EMAIL){
        Map map=new HashMap<>();
        map.put("C_ID",C_ID);
        map.put("C_NAME",C_NAME);
        map.put("C_AGE",C_AGE);
        map.put("GENDER",GENDER);
        map.put("C_EMAIL",C_EMAIL);
        map.put("C_USERNAME",C_USERNAME);
        map.put("C_PASSWORD",C_PASSWORD);
        System.out.println(loginDao.updateUser(map));
        return loginDao.updateUser(map)>0 ;
    }

    public Map findById(String id) {
        return  loginDao.findById(id);
    }

    public boolean register(String C_NAME, String C_USERNAME, String C_PASSWORD, String C_AGE, String GENDER, String C_EMAIL) {
        Map map=new HashMap();
        map.put("C_NAME",C_NAME);
        map.put("C_USERNAME",C_USERNAME);
        map.put("C_PASSWORD",C_PASSWORD);
        map.put("C_AGE",C_AGE);
        map.put("GENDER",GENDER);
        map.put("C_EMAIL",C_EMAIL);
        return  loginDao.insertUser(map)>0;

    }
    public boolean findByName(String C_USERNAME) {

        return  loginDao.findByName(C_USERNAME).size()>0;

    }

    public boolean deleteuser(String id) {
        return loginDao.deleteUser(id)>0;
    }

    public Map findBookByName(String name) {

        return  loginDao.findBookByName(name);


    }
    public int allBooks(String name){

        return loginDao.allBooks(name);
    }


    public int othersBooks(String name){



        return loginDao.othersBooks(name);
    }
    public  int  permision(String username){
        Map map=new HashMap();
        map.put("C_USERNAME",username);

        return  loginDao.permission(map);
    }
}
