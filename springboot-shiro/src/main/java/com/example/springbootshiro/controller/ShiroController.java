package com.example.springbootshiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShiroController {

    @RequestMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", "hello shiro");
        return "index";
    }

    @RequestMapping("/user/update")
    public String update() {
        return "user/update";
    }

    @RequestMapping("/user/add")
    public String add() {
        return "user/add";
    }

    @RequestMapping("/tologin")
    public String tologin() {

        return "login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行登入方法，有异常抛出异常
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户信息错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

}
