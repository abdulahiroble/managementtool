package com.managementtool.demo.controller;

import javax.servlet.http.HttpServletResponse;

import com.managementtool.demo.models.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmployeeController {
    Employee employee = new Employee();

    // mangler service her
    @GetMapping("/myemployees")
    public String myEmployees(Model employeeModel) {
        employeeModel.addAttribute("employeeModel", employeeModel);

        return "myemployees";
    }

    // @PostMapping("/postCreate")
    // public String postCreate(WebRequest dataFromForm, HttpServletResponse
    // response) {

    // try {
    // String firstname = dataFromForm.getParameter("firstname");
    // String lastname = dataFromForm.getParameter("lastname");
    // String email = dataFromForm.getParameter("email");
    // String password = dataFromForm.getParameter("password");
    // String address = dataFromForm.getParameter("address");
    // String postal = dataFromForm.getParameter("postal");
    // String city = dataFromForm.getParameter("city");
    // String profession = dataFromForm.getParameter("profession");
    // String rate = dataFromForm.getParameter("rate");
    // String phone = dataFromForm.getParameter("phone");
    // String idemployee = dataFromForm.getParameter("idemployee");

    // employee = new Employee(firstname, lastname, email, password, address,
    // postal, city, profession, rate
    // , phone

    // //mangler service.insertNewManager(manager);
    // } catch (Exception e) {
    // System.out.println("Fejl:" + e);

    // }

    // return "home";

    // }
}
