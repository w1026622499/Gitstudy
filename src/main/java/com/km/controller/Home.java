package com.km.controller;

import com.km.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author Wh
 * @title
 * @description
 * @createTime 2021年02月04日 12:22:00
 * @modifier：Wh
 * @modification_time：2021-02-04 12:22
 */
@Controller
public class Home {

    @RequestMapping("/index")
    public String index(String name){
        System.out.println("kkkkkkkkeeekkkkkkk");
        return "sk";
    }

    @PostMapping("/index2")
    @ResponseBody
    public String index(@RequestBody User user){
        System.out.println(user);
        return user.getEmpName();
    }


    @PostMapping("/file")
    public String file(String username, MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        file.transferTo(new File("D:\\迅雷云盘\\"+filename));
        return username;
    }
}


