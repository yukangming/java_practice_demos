package com.yukangming.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("attr")
public class AttrController {

    @RequestMapping("test")
    public String test(HttpServletRequest request, HttpServletResponse response) {
        String name = "yukangming";
        request.setAttribute("name", name);
        return "attr";
    }
}
