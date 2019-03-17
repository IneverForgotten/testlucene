package com.baizhi.conf;

import com.baizhi.dao.ShoppingDao;
import com.baizhi.dao.ShoppingDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LunceneConf {
    @Bean("shoppingDao")
    public ShoppingDao getShoppingDao(){
        return new ShoppingDaoImpl();
    }
}
