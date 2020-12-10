package com.managementtool.demo.controller;

import java.util.List;

import com.managementtool.demo.models.Project;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.services.ProjectService;
import com.managementtool.demo.services.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TaskController {
    
    @GetMapping("/mytasks")
    public String showProject(Model model)
    {
        List<Task> task = new TaskService().getAllTasks();
        model.addAttribute("task",task);

        return "mytasks";
    }
}
