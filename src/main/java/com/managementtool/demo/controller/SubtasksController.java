package com.managementtool.demo.controller;

import javax.servlet.http.HttpServletRequest;

import com.managementtool.demo.models.Manager;
import com.managementtool.demo.models.Subtask;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.services.ManagerService;
import com.managementtool.demo.services.SubtaskService;
import com.managementtool.demo.services.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SubtasksController {
    ManagerService managerService = new ManagerService();
    SubtaskService subtaskService = new SubtaskService();
    Task task = new Task();

    @GetMapping("/createSubtask")
    public String createSubtask(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "createSubtask";
    }
    
    @GetMapping("/subtasks")
    public String showSubtasks(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "subtasks";
    }

     @PostMapping("/postCreateSubtask")
     public String postCreate(Model model, WebRequest dataFromForm, HttpServletRequest request) {

          int cookieId = managerService.getCookieId(request);
          Manager activeManager = managerService.getManagerByID(cookieId);

          model.addAttribute("project", activeManager);

         try {
               String subtaskname = dataFromForm.getParameter("subtaskname");

               String date = dataFromForm.getParameter("date");

               Subtask subtask = new Subtask(subtaskname, date);

               subtaskService.insertNewSubtask(subtask);
         } catch (Exception e) {
             System.out.println("Fejl:" + e);

         }

         return "redirect:/subtasks";
     }
    
}
