package com.managementtool.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class SubtasksController {
    ManagerService managerService = new ManagerService();
    SubtaskService subtaskService = new SubtaskService();
    Subtask subtask = new Subtask();
    TaskService taskService = new TaskService();

    /**
	 * Returnerer createSubtask.html siden.
     * @param projectModel
     * @param request
	 * @return
	 */
    @GetMapping("/createSubtask")
    public String createSubtask(Model projectModel, HttpServletRequest request) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        projectModel.addAttribute("activeManager", activeManager);

        return "createSubtask";
    }
    
    /**
	 * Returnerer subtasks.html siden.
     * @param subtaskModel
     * @param request
     * @param request
     * @param idtask
     * @param "idtask"
	 * @return
	 */
    @GetMapping("/subtasks")
    public String showSubtasks(Model subtaskModel, HttpServletRequest request, @PathVariable(value = "idtask") int idtask) {

        int cookieId = managerService.getCookieId(request);
        Manager activeManager = managerService.getManagerByID(cookieId);
        
        subtaskModel.addAttribute("activeManager", activeManager);

        // List<Subtask> subtasksList = new SubtaskService().getAllSubtasks();

        // List<Task> tasksList = new TaskService().getAllTasks();

        // subtaskModel.addAttribute("tasksList", tasksList);

        // subtaskModel.addAttribute("subtasksList", subtasksList);

        // subtaskService.insertIdTaskToTaskId(subtask);

        // Task taskToView = taskService.getTaskById(idtask);

        // subtaskModel.addAttribute("taskToView", taskToView);

        return "subtasks";
    }

    /**
	 * Redirecter til subtasks.html siden efter subtask er opretter med navn og dato
     * @param model
     * @param dataFromForm
     * @param request
	 * @return
	 */
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
