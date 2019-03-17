package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.baizhi.dao")
public class Testlucene2Application {

    public static void main(String[] args) {
        SpringApplication.run(Testlucene2Application.class, args);
    }

}
