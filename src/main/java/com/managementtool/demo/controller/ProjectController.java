package com.managementtool.demo.controller;

import com.managementtool.demo.models.Category;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.models.Project;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.services.CategoryService;
import com.managementtool.demo.services.ManagerService;
import com.managementtool.demo.services.ProjectService;
import com.managementtool.demo.services.TaskService;

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
    Category category = new Category();
    CategoryService categoryService = new CategoryService();
    Task task = new Task();
    TaskService taskService = new TaskService();

    @GetMapping("/createProject")
    public String createProject(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "createProject";
    }

    @GetMapping("/projects")
    public String showProject(Model model, HttpServletRequest request)
    {
        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("project", activeManager);

        List<Project> projectName = new ProjectService().getAllProjects();

        List<Category> categoryName = new CategoryService().getAllCategorys();

        List<Task> TaskName = new TaskService().getAllTasks();
        
        categoryService.insertProjectIdToCategory(category);

        taskService.insertCategoryId(task);

        model.addAttribute("TaskName", TaskName);
        
        model.addAttribute("categoryName", categoryName);

        projectService.insertManagerId(project);

        model.addAttribute("projectName", projectName);

        return "projects";
    }

    @PostMapping("/postCreateProject")
    public String postCreate(Model model, WebRequest dataFromForm, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);

        model.addAttribute("project", activeManager);

        try {
            String projectname = dataFromForm.getParameter("projectname");

            Project project = new Project(projectname);

            // projectService.insertManagerId(project);

             projectService.insertNewProject(project);
        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "redirect:/addcategory";
    }
}
