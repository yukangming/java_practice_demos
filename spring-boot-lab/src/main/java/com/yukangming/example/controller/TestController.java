package com.yukangming.example.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @GetMapping("/yukangming/test/query")
    public void test() {
        System.out.println("这是经过前置处理后的方法");
        System.out.println("this is a method after before advice");
    }
}
