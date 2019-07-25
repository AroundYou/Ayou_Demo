package com.example.RJRJ.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Deseiption
 * @Author AYOU
 * @Date 2018/12/31 14:27
 * @Version 1.0
 **/ 
@RestController
@RequestMapping("/you")
public class HelloController {
    
     @RequestMapping("/say")
    public String say(){
        return "hello,world";
    }
}
