package cn.aixuxi.livedays.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述 首页controller
 *
 * @author ruozhuliufeng
 * @version 1.0
 * @date 2020/6/6 12:45
 */
@Controller
public class IndexController {
    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/login")
    public String login(){
        return "redirect:/";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

}
