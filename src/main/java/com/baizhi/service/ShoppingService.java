package com.baizhi.service;

import com.baizhi.entity.Shopping;

import java.io.IOException;
import java.util.List;

public interface ShoppingService {
    void insertIndex(Shopping shopping);
    void insertDB(Shopping shopping) throws IOException;
    List<Shopping> qeuryIndex(String s) throws IOException;
}
