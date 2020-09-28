package com.yukangming.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/hello")
public class HelloController {

    @RequestMapping("/methodhello")
    public String hello() {
        System.out.println("hello this is my first springmvc example");
        return "index";
    }
}
