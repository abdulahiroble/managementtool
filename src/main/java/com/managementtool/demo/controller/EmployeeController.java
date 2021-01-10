package com.managementtool.demo.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.EmployeeTask;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.services.EmployeeService;
import com.managementtool.demo.services.EmployeeTaskService;
import com.managementtool.demo.services.ManagerService;
import com.managementtool.demo.services.TaskService;

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
    ManagerService managerService = new ManagerService();
    TaskService taskService = new TaskService();
    Manager manager = new Manager();
    Cookie cookie;
    Task task = new Task();
    EmployeeTaskService employeeTaskService = new EmployeeTaskService();
    EmployeeTask employeeTask = new EmployeeTask();

    @GetMapping("/addemployeetotask")
    public String addemployeeToTask(Model model) {

        List<Employee> listEmployee = employeeService.getAllEmployees();

        model.addAttribute("listEmployee", listEmployee);
        

        List<Task> tasksList = new TaskService().getAllTasks();
    
        model.addAttribute("tasksList", tasksList);

        List<EmployeeTask> listEmployeeTask = employeeTaskService.getAllEmployeesTask();

        model.addAttribute("listEmployeeTask", listEmployeeTask);

        return "addemployeetotask";
    }

    @PostMapping("/createAddemployeetotask")
    public String createAddemployeetotask(Model model, WebRequest dataFromForm) {

        try {
            String firstname = dataFromForm.getParameter("firstname");

            String taskname = dataFromForm.getParameter("taskname");

            Employee employeeToDisplay = new Employee(firstname);

            Task taskToDisplay = new Task(taskname);

            model.addAttribute("employeeToDisplay", employeeToDisplay);

            model.addAttribute("taskToDisplay", taskToDisplay);

            employeeTask = new EmployeeTask(firstname, taskname);

            employeeTaskService.insertNewEmployeeTask(employeeTask);

             employeeService.insertEmployeeToTask(employeeToDisplay);

             taskService.insetTaskToEmployee(taskToDisplay);

             employeeService.insertTaskId(employeeToDisplay);


      } catch (Exception e) {
          System.out.println("Fejl:" + e);

      }

      return "redirect:/addemployeetotask";
    }

    

    @GetMapping("/myemployees")
    public String myEmployees(Model model, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("employee", activeManager);

        return showEmployeeList(model, request);
    }

    @GetMapping("/createemployee")
    public String createEmployee() {
        return "createemployee";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee") Employee employee, HttpServletRequest request, Model model) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("employee", activeManager);

        try {
            employeeService.updateEmployee(employee);
            System.out.println("Saved to db");
        } catch (Exception e) {
            System.out.println("Error can't update employee " + e);
        }

        return "redirect:/myemployees";
    }

    @GetMapping("/deleteEmployee/{idemployee}")
    public String deleteEmployee(@PathVariable(value = "idemployee") int idemployee, HttpServletRequest request, Model model) {
        
        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("employee", activeManager);

        try {
            employeeService.deleteEmployee(idemployee);
        } catch (Exception e) {
            System.out.println("Error can't delete employee " + e);
        }

        return "redirect:/myemployees";
    }

    @PostMapping("/postCreateEmployee")
    public String postCreateEmployee(WebRequest dataFromForm, HttpServletResponse response, HttpServletRequest request, Model model) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("employee", activeManager);

        try {

            String firstname = dataFromForm.getParameter("firstname");
            String lastname = dataFromForm.getParameter("lastname");
            String email = dataFromForm.getParameter("email");
            String password = dataFromForm.getParameter("password");
            String address = dataFromForm.getParameter("address");
            String postal = dataFromForm.getParameter("postal");
            String city = dataFromForm.getParameter("city");
            String profession = dataFromForm.getParameter("profession");
            int rate = Integer.parseInt(request.getParameter("rate"));
            int phone = Integer.parseInt(request.getParameter("phone"));

            employee = new Employee(firstname, lastname, email, password, address, postal, city, profession, rate,
                    phone);

            employeeService.insertNewEmployee(employee);
            employeeService.insertManagerId(employee);

        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "redirect:/myemployees";

    }

    @GetMapping("/employeeFormToView/{idemployee}")
    public String employeeFormToView(@PathVariable(value = "idemployee") int idemployee, Model model, HttpServletResponse response, HttpServletRequest request) {
        
        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("employee", activeManager);
        
        try {

            Employee employeeToView = employeeService.getEmployeeByID(idemployee);


            model.addAttribute("employeeToView", employeeToView);
        } catch (Exception e) {
            System.out.println("Error can't show employee profile " + e);
        }
        return "updateemployee";
    }

    public String showEmployeeList(Model model, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("employee", activeManager);

        try {

            List<Employee> listEmployee = employeeService.getAllEmployees();

            model.addAttribute("listEmployee", listEmployee);

        } catch (Exception e) {
            System.out.println("Error can't load up list " + e);
        }
        return "myemployees";
    }

}
