package com.managementtool.demo.controller;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.services.EmployeeService;
import com.managementtool.demo.services.ManagerService;
import org.springframework.ui.Model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {

    Manager manager = new Manager();
    ManagerService managerService = new ManagerService();
    Employee employee = new Employee();
    EmployeeService employeeService = new EmployeeService();

    @GetMapping("/createaccount")
    public String createAccount(Model managerModel) {
        managerModel.addAttribute("managerModel", managerModel);

        return "createaccount";
    }

    @GetMapping("/login")
    public String loginAccount(Model usermModel) {

        Manager managerToDisplay = new Manager();

        usermModel.addAttribute("employeeService", employeeService);

        usermModel.addAttribute("managerToDisplay", managerToDisplay);

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

    @PostMapping("/postLogin")
    public String userLogin(WebRequest dataFromForm, HttpServletResponse response) {

        List<Manager> managerFromDB = managerService.getAllManagersLoginInformation();

        String enteredEmail = dataFromForm.getParameter("email");
        String enteredPassword = dataFromForm.getParameter("password");

        for (Manager manager : managerFromDB)
            if (manager.getEmail().equals(enteredEmail) && manager.getPassword().equals(enteredPassword)) {
                manager = managerService.loggedInManager(enteredEmail, enteredPassword);
                 
                String id = "" + managerService.getSingleManager(dataFromForm.getParameter("email")).getIdmanager();
                
                Cookie cookie = new Cookie("id", id);
                 response.addCookie(cookie);


            return "redirect:/myemployees";
            }

            return "redirect:/create";
    }


}
