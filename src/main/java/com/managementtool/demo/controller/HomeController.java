package com.managementtool.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /**
	 * Retunerer home.html
	 * @return
	 */
    @GetMapping("/")
    public String homePage() {
        return "home";
    }
}
