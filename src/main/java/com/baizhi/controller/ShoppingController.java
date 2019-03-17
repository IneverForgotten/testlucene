package com.baizhi.controller;

import com.alibaba.fastjson.JSONArray;
import com.baizhi.entity.Shopping;
import com.baizhi.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/shop")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;
    @RequestMapping("/write")
    public String write(Shopping shopping, @DateTimeFormat(pattern = "yyyy-MM-dd") Date addtiems,MultipartFile upFile, HttpSession session) throws IOException {
        System.out.println(shopping +"------------------------------------------------");
        System.out.println(addtiems+"******************************************************");
        String filename = upFile.getOriginalFilename();
        String realPath = session.getServletContext().getRealPath("/upFile");
        File file = new File(realPath + "/" + filename);
        if(!file.exists()){
            file.createNewFile();
        }
        upFile.transferTo(file);
        shopping.setSrc("/upFile/"+filename);
        shopping.setAddTime(addtiems);
        System.out.println(shopping+"//////////////////////////////////////");
        shoppingService.insertDB(shopping);
        return "forward:/index.jsp";
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Shopping> search(String shopping) throws IOException {

        System.out.println(shopping+"-------------------");
        List<Shopping> shoppings = shoppingService.qeuryIndex(shopping);
        System.out.println(shoppings);
        return shoppings;

    }

}
