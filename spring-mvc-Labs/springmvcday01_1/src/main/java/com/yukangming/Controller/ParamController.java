package com.yukangming.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("param")
public class ParamController {

    @RequestMapping("test")
    public  String test(String name) {
        System.out.println("name :"+name);
        return "index";
    }
}
