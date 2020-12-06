package com.managementtool.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.services.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmployeeController {
    Employee employee = new Employee();
    EmployeeService employeeService = new EmployeeService();

    @GetMapping("/myemployees")
    public String myEmployees(Model model) {
        return showEmployeeList(model);
    }

    @GetMapping("/createemployee")
    public String createEmployee() {
        return "createemployee";
    }

    @PostMapping("/postCreateEmployee")
    public String postCreateEmployee(WebRequest dataFromForm, HttpServletResponse response) {

        try {
            String firstname = dataFromForm.getParameter("firstname");
            String lastname = dataFromForm.getParameter("lastname");
            String email = dataFromForm.getParameter("email");
            String password = dataFromForm.getParameter("password");
            String address = dataFromForm.getParameter("address");
            String postal = dataFromForm.getParameter("postal");
            String city = dataFromForm.getParameter("city");
            String profession = dataFromForm.getParameter("profession");
            String rate = dataFromForm.getParameter("rate");
            String phone = dataFromForm.getParameter("phone");

            /*
             * String rate = String.valueOf(dataFromForm.getParameter(rate)); String postal
             * = String.valueOf(dataFromForm.getParameter(postal)); String phone =
             * String.valueOf(dataFromForm.getParameter(phone));
             */

            employee = new Employee(firstname, lastname, email, password, address, postal, city, profession, rate,
                    phone);

            employeeService.insertNewEmployee(employee);

        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "myemployees";

    }

    public String showEmployeeList(Model model) {

        try {

            List<Employee> listEmployee = employeeService.getAllEmployees();

            model.addAttribute("listEmployee", listEmployee);

        } catch (Exception e) {
            System.out.println("Error can't load up list " + e);
        }
        return "myemployees";
    }

}
