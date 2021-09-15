package com.example.springsecurity.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wzq
 * @Date 2021/9/15
 **/
@RestController
@RequestMapping("/app/api/")
public class AppController {

    @GetMapping("hello")
    public String hello(){
        return "hello,app";
    }
}
