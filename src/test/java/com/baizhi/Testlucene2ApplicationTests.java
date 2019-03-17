package com.baizhi;

import com.baizhi.dao.ShoppingDao;
import com.baizhi.entity.Shopping;
import com.baizhi.service.ShoppingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Testlucene2ApplicationTests {
    @Autowired
    private ShoppingService shoppingDao;
    @Test
    public void contextLoads() throws IOException {
        List<Shopping> shoppings = shoppingDao.qeuryIndex("我");
        System.out.println(shoppings.size());
        for (Shopping shopping : shoppings) {
            System.out.println(shopping);
        }
    }

}
