package com.xza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 拾柒
 * @create 2020/3/19
 */
@Controller
public class IndexController {

    @RequestMapping({"/","/index.html","index"})
    public String index(){
        return "login";
    }

}
