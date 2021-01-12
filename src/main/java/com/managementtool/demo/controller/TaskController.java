package com.managementtool.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.managementtool.demo.models.Manager;
import com.managementtool.demo.models.Project;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.services.ManagerService;
import com.managementtool.demo.services.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;


@Controller
public class TaskController {
    ManagerService managerService = new ManagerService();
    TaskService taskService = new TaskService();
    Task task = new Task();
    
    /**
	 * Returnerer createtask.html.
     * @param projectModel
     * @param request
	 * @return
	 */
    @GetMapping("/createtask")
    public String createProject(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "createtask";
    }

     /**
	 * Redirecter til projects.html som opretter en ny task hvor den tager data fra formen.
     * @param model
     * @param dataFromForm
     * @param request
	 * @return
	 */
     @PostMapping("/postCreateTask")
     public String postCreate(Model model, WebRequest dataFromForm, HttpServletRequest request) {

          int cookieId = managerService.getCookieId(request);
          Manager activeManager = managerService.getManagerByID(cookieId);

          model.addAttribute("project", activeManager);

         try {
               String taskname = dataFromForm.getParameter("taskname");

               String time = dataFromForm.getParameter("time");

               String cost = dataFromForm.getParameter("cost");

               String deadline = dataFromForm.getParameter("deadline");

               Task task = new Task(taskname, time, cost, deadline);

              // taskService.insertCategoryId(task);

               taskService.insertNewTask(task);
         } catch (Exception e) {
             System.out.println("Fejl:" + e);

         }

         return "redirect:/projects";
     }
    
}
