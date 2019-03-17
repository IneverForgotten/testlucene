package com.baizhi.dao;

import com.baizhi.entity.Shopping;

import java.util.List;

public interface ShoppingDao {

    void insertDB(Shopping shopping);
    List<Shopping> qeuryIndex(String s);

}
