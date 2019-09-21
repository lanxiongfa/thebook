package com.spring.mvc.dao;

import java.util.List;
import java.util.Map;

public interface LoginAndUserDao {

    List<Map> login(Map map);
    List<Map>  findAllBook();
    List<Map>  findAllUser();
     int   updateUser(Map map);
     int   deleteUser(String id);
    int permission(Map map);
    Map findById(String id);

    int insertUser(Map map);
    List<Map> findByName(String C_USERNAME);

    Map findBookByName(String name);

    int allBooks(String name);
    int othersBooks(String name);


}
