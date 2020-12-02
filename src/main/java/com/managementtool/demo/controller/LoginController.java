package com.managementtool.demo.controller;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.services.ManagerService;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    Manager manager = new Manager();
    ManagerService managerService = new ManagerService();

    @GetMapping("/createaccount")
    public String createAccount(Model managerModel) {
        managerModel.addAttribute("managerModel", managerModel);

        return "createaccount";
    }

    @GetMapping("/login")
    public String loginAccount() {
        return "login";
    }


    @PostMapping("/postCreate")
    public String postCreate(WebRequest dataFromForm, HttpServletResponse response) {

        try {
            String firstname = dataFromForm.getParameter("firstname");
            String lastname = dataFromForm.getParameter("lastname");
            String company = dataFromForm.getParameter("email");
            String email = dataFromForm.getParameter("email");
            String password = dataFromForm.getParameter("password");
            String phone = dataFromForm.getParameter("phone");

            manager = new Manager(firstname, lastname, company, email, password, phone);

            managerService.insertNewManager(manager);
        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

         return "home";

    }
    
}
