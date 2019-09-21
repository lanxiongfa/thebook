/*
package com.spring.mvc.service;


import com.spring.mvc.controller.IndexController;
import com.spring.mvc.dao.UserDao;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.spring.mvc.test.Test.getCellValue;


@Service
public class IndexService {
    //    public List<Map> findList() {
//        List<Map> list = new ArrayList<>();
//        Map map1 = new HashMap();
//        map1.put("id", "22222222222");
//        map1.put("name", "zhenshuai");
//        list.add(map1);
//
//
//        Map map2 = new HashMap();
//        map2.put("id", "22222222222");
//        map2.put("name", "zhenshuai");
//        list.add(map2);
//        return list;
//    }
    @Autowired
    private UserDao userDao;

    public static List<Map>getExcel() throws IOException, InvalidFormatException {
        File file = new File("D:\\2019年5月份 全市地方财政收入完成情况（修改上年口径）.xlsx");
        Workbook workbook = WorkbookFactory.create(new FileInputStream(file));
        Sheet sheet = workbook.getSheetAt(0);
        List<Map> list = new ArrayList<>();
        for (int i = 3; i < 27; i++) {

            Row row = sheet.getRow(i);

            String cell1 = getCellValue(row.getCell(0));
            String cell2 = getCellValue(row.getCell(1));
            String cell3 = getCellValue(row.getCell(2));
            String cell4 = getCellValue(row.getCell(3));
            String cell5 = getCellValue(row.getCell(4));
            String cell6 = getCellValue(row.getCell(5));
            String cell7 = getCellValue(row.getCell(6));
            String cell8 = getCellValue(row.getCell(7));

            Map map = new HashMap();
            map.put("cell1", cell1);
            map.put("cell2", cell2);
            map.put("cell3", cell3);
            map.put("cell4", cell4);
            map.put("cell5", cell5);
            map.put("cell6", cell6);
            map.put("cell7", cell7);
            map.put("cell8", cell8);
            list.add(map);


        }
        return list;
    }
//
//    public List<Map> getvalue() {
//        return userDao.findAll();
//    }
//
//    public List<Map> getName() {
//        Map map =new HashMap();
//        map.put("stu_name","ls");
//      return userDao.getByName(map);
//    }
//    public List<Map> insert(){
//
//
//        Map map =new HashMap();
//        map.put("stu_id","1005");
//        map.put("stu_name","wx");
//        map.put("stu_age","25");
//
//        System.out.println(map);
//        return userDao.insert(map);
//    }
//    public List<Map> update(){
//        Map map=new HashMap();
//        map.put("stu_name","ws");
//        map.put("stu_id","1003");
//        return userDao.update(map);
//    }
    public boolean login(String username, String pwd){
        Map map =new HashMap();
        map.put("username",username);
        map.put("pwd",pwd);

        return userDao.login(map).size()>0;
    }
    public int zhuche(String username,String pwd,String login_name,String sex){
        Map map=new HashMap();
        map.put("username",username);
        map.put("pwd",pwd);
        map.put("login_name",login_name);
        map.put("sex",sex);
        return userDao.insert(map);
    }

    public boolean getName(String username){
        Map map =new HashMap();
        map.put("username",username);
        return userDao.login_username(map).size()>0;


    }
    public List<Map> findAll(){
        return userDao.findAll();
    }


    public boolean delectById(int id) {
        Map map =new HashMap();
        map.put("id",id);
        return userDao.deleteById(map)>0;
    }

    public List<Map> selectById(int id) {
        Map map =new HashMap();
        map.put("id",id);
        return userDao.selectById(map);
    }

    public boolean updateById(String id ,String username , String pwd ,String login_name,String sex  ) {
        Map map =new HashMap();
        map.put("id",id);
        map.put("username",username);
        map.put("pwd",pwd);
        map.put("login_name",login_name);
        map.put("sex",sex);
        return userDao.updateById(map)>0;


    }

    public Map findById(String id) {
        Map map=new HashMap();
        map.put("id",id);
        return userDao.findById(map);
    }
}







*/
