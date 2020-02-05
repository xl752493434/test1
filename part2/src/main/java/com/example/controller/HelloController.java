package com.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//表示修饰该所有的方法返回JSON格式,直接可以编写Restful接口
@RestController
//让 Spring Boot 根据应用所声明的依赖来对 Spring 框架进行自动配置
@EnableAutoConfiguration

public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World ,my name is XL";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }

}
