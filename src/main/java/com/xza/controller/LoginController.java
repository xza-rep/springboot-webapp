package com.xza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author 拾柒
 * @create 2020/3/21
 */
@Controller
public class LoginController {

    @PostMapping("/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session, Model model){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }

    }

    //注销请求
    @GetMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "login";
    }
}
