package com.managementtool.demo.controller;

import com.managementtool.demo.models.Manager;
import com.managementtool.demo.models.Project;
import com.managementtool.demo.services.ManagerService;
import com.managementtool.demo.services.ProjectService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProjectController {
    Project project = new Project();
    ProjectService projectService = new ProjectService();
    ManagerService managerService = new ManagerService();

    @GetMapping("/createProject")
    public String createProject(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "createProject";
    }

    @GetMapping("/projects")
    public String showProject(Model model)
    {

        List<Project> project = new ProjectService().getAllProjects();
        model.addAttribute("project",project);

        return "projects";
    }

    @PostMapping("/postCreateProject")
    public String postCreate(WebRequest dataFromForm, HttpServletResponse response) {

        try {
            String projectname = dataFromForm.getParameter("projectname");

            Project project = new Project(projectname);

             projectService.insertNewProject(project);
        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "redirect:/projects";
    }
}
