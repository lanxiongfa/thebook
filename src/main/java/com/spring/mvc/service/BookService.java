package com.spring.mvc.service;

import com.spring.mvc.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {


    @Autowired
    private BookDao bookDao;
    public List<Map> findAllBook() {
        return bookDao.findAllBook();
    }

    public List<Map> findBookByName(String name) {
        return bookDao.findBookByName(name);
    }

    public List<Map> bookbase(String name) {
        return  bookDao.bookbase(name);
    }

    public Map showAll(String id) {
        return  bookDao.showAll(id);
    }

    public int borrowbook(String sta, String bid, String cid) {
        Map map=new HashMap();
        map.put("B.B_STA",sta);
        map.put("B.B_ID",bid);
        map.put("U.C_ID",cid);
        return  bookDao.borrow(map);
    }
}
