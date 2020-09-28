package com.yukangming.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "forwardAndRedirect")
public class ForwardAndRedirectController {

    @RequestMapping("test1")
    public String test() {
        System.out.println("test1");
        return "index";
    }

    @RequestMapping("test2")
    public String test2() {
            System.out.println("test2");
            return "redirect:/index.jsp";
    }

    @RequestMapping("test3")
    public String test3() {
        System.out.println("test3");
        return  "forward:/hello/methodhello";
    }

    @RequestMapping("test4")
    public String test4() {
        System.out.println("test2");
        return "redirect:/forwardAndRedirect/test3";
    }
}
