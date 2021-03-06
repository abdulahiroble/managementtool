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


    /**
	 * Retunerer createaccount.html
     * @param managerModel
	 * @return
	 */
    @GetMapping("/createaccount")
    public String createAccount(Model managerModel) {
        managerModel.addAttribute("managerModel", managerModel);

        return "createaccount";
    }

    
    /**
	 * Retunerer login.html ud fra om man er logget ind enten som manager eller employee
     * @param userModel
	 * @return
	 */
    @GetMapping("/login")
    public String loginAccount(Model usermModel) {

        Manager managerToDisplay = new Manager();

        usermModel.addAttribute("employeeService", employeeService);

        usermModel.addAttribute("managerToDisplay", managerToDisplay);

        return "login";
    }

    /**
	 * Retunerer home.html og tager oplysinger fra formen og opretter en ny manager.
     * @param dataFromForm
     * @param response
     * @param request
	 * @return
	 */
    @PostMapping("/postCreate")
    public String postCreate(WebRequest dataFromForm, HttpServletResponse response, HttpServletRequest request) {

        try {
            String firstname = dataFromForm.getParameter("firstname");
            String lastname = dataFromForm.getParameter("lastname");
            String company = dataFromForm.getParameter("company");
            String email = dataFromForm.getParameter("email");
            String password = dataFromForm.getParameter("password");
            int phone = Integer.parseInt(request.getParameter("phone"));

            manager = new Manager(firstname, lastname, company, email, password, phone);

            managerService.insertNewManager(manager);
        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "home";

    }

    /**
	 * Redirecter til projects.html hvis man logger ind som manager eller mytasks.html hvis man logger ind som employee. Ellers bliver 
     * man redirected til create.html hvor man kan opretter en ny manager.
     * @param dataFromForm
     * @param response
	 * @return
	 */
    @PostMapping("/postLogin")
    public String userLogin(WebRequest dataFromForm, HttpServletResponse response) {

        List<Manager> managerFromDB = managerService.getAllManagersLoginInformation();
        List<Employee> employeeFromDB = employeeService.getAllEmployeesLoginInformation();

        String enteredEmail = dataFromForm.getParameter("email");
        String enteredPassword = dataFromForm.getParameter("password");

        for (Manager manager : managerFromDB)
            if (manager.getEmail().equals(enteredEmail) && manager.getPassword().equals(enteredPassword)) {
                
                manager = managerService.loggedInManager(enteredEmail, enteredPassword);

                String idmanager = "" + managerService.getSingleManager(dataFromForm.getParameter("password")).getIdmanager();

                Cookie cookie = new Cookie("idmanager", idmanager);

                response.addCookie(cookie);


            return "redirect:/projects";
            }

        for (Employee employee : employeeFromDB)
            if (employee.getEmail().equals(enteredEmail) && employee.getPassword().equals(enteredPassword)) {

                employee = employeeService.loggedInEmployee(enteredEmail, enteredPassword);

                String idemployee = "" + employeeService.getSingleEmployee(dataFromForm.getParameter("email")).getIdemployee();

                Cookie cookie = new Cookie("idemployee", idemployee);

                response.addCookie(cookie);

                return "redirect:/mytasks";
            }

            return "redirect:/create";


    }


}
