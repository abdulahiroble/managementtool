package com.managementtool.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.managementtool.demo.models.Manager;
import com.managementtool.demo.models.Project;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.services.ManagerService;
import com.managementtool.demo.services.ProjectService;
import com.managementtool.demo.services.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class TaskController {
    ManagerService managerService = new ManagerService();
    
    @GetMapping("/createtask")
    public String createProject(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "createtask";
    }

    @PostMapping("/postCreateProject")
    public String postCreate(Model model, WebRequest dataFromForm, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("project", activeManager);

        try {
            // String projectname = dataFromForm.getParameter("projectname");

            // Project project = new Project(projectname);

            // projectService.insertManagerId(project);

             // projectService.insertNewProject(project);
        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "redirect:/projects";
    }
    
}
