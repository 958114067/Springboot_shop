package com.example.demo_1.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController{
    @Value("${value.test}")
    String param;
    @RequestMapping("/listDorminfo1")
    public String test(){
        return param;
    }
}
