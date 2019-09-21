package com.spring.mvc.dao;

import java.util.List;
import java.util.Map;

public interface BookDao {

    List<Map> findAllBook();
    List<Map> findBookByName(String name);

    List<Map> bookbase(String name);

    Map showAll(String id);
    int borrow(Map map);
}
