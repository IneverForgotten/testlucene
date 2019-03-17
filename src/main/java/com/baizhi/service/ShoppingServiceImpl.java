package com.baizhi.service;

import com.baizhi.dao.Shopping2Dao;
import com.baizhi.dao.ShoppingDao;
import com.baizhi.entity.Shopping;
import com.baizhi.util.LuceneUtil;
import org.apache.lucene.document.*;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingDao shoppingDao;
    @Autowired
    private Shopping2Dao shopping2Dao;
    @Override
    public void insertIndex(Shopping shopping) {

    }
    @Override
    public void insertDB(Shopping shopping) throws IOException {
        shopping2Dao.insertDB(shopping);
        shoppingDao.insertDB(shopping);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Shopping> qeuryIndex(String s)  throws IOException{
        return shoppingDao.qeuryIndex(s);
    }
}
