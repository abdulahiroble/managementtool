package com.managementtool.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

    @GetMapping("/")
    public String homePage() {
        return "login";
    }
}
