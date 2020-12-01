package com.managementtool.demo.controller;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/createaccount")
    public String createAccount(Model accountModel) {
        accountModel.addAttribute("accountModel", accountModel);

        return "createaccount";
    }

    @GetMapping("/login")
    public String loginAccount() {
        return "login";
    }
    
}
