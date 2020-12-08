package com.managementtool.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.services.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class EmployeeController {
    Employee employee = new Employee();
    EmployeeService employeeService = new EmployeeService();
    List<Employee> listEmployee;

    @GetMapping("/myemployees")
    public String myEmployees(Model model) {
        return showEmployeeList(model);
    }

    @GetMapping("/createemployee")
    public String createEmployee() {
        return "createemployee";
    }

    @PostMapping("/updateEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        try {
            employeeService.updateEmployee(employee);
        } catch (Exception e) {
            System.out.println("Error can't save to database " + e);
        }

        return "myemployees";
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

            employee = new Employee(firstname, lastname, email, password, address, postal, city, profession, rate,
                    phone);

            employeeService.insertNewEmployee(employee);

        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "myemployees";

    }

    @GetMapping("/employeeFormToUpdate/{idemployee}")
    public String employeeFormToUpdate(@PathVariable(value = "idemployee") int idemployee, Model model) {
        try {

            Employee employee = employeeService.getEmployeeByID(idemployee);

            model.addAttribute("employee", employee);
        } catch (Exception e) {
            System.out.println("Error can't show employee profile " + e);
        }
        return "updateemployee";
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
