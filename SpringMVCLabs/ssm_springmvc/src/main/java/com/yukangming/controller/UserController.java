package com.yukangming.controller;


import com.yukangming.entity.User;
import com.yukangming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request) {
        List<User> users = userService.findAll();
        request.setAttribute("users", users);
        return "findAll";
    }

}
