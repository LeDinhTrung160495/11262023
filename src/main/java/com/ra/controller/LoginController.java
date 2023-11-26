package com.ra.controller;

import com.ra.dto.request.FormLoginDTO;
import com.ra.model.Account;
import com.ra.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loginController")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login";
    }
    @PostMapping(value = "/checkLogin")
    public String login(@ModelAttribute Account body) {
        if(loginService.login(body.getUserName(), body.getPassword())){
            return "redirect:/productController/findProduct";
        }
        return "error";
    }
}
