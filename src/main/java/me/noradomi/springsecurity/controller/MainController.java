package me.noradomi.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Asus on 4/24/2020.
 */
@Controller
public class MainController {
//    Do việc xử lí submit form login = Post /login sẽ do Spring Security quản lí, nên mặc định
//    khỏi làm trong Controller
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/403")
    public String accessDenied(){
        return "403";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
}
