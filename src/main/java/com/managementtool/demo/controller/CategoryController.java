package com.managementtool.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.managementtool.demo.models.Category;
import com.managementtool.demo.models.Manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.managementtool.demo.services.CategoryService;
import com.managementtool.demo.services.ManagerService;
import org.springframework.ui.Model;

@Controller
public class CategoryController {
    ManagerService managerService = new ManagerService();
    CategoryService categoryService = new CategoryService();
    Category category = new Category();

    @GetMapping("/addcategory")
        public String showAddCategory(Model model, HttpServletRequest request) {

            int cookieId = managerService.getCookieId(request);
            Manager activeManager = managerService.getManagerByID(cookieId);
            model.addAttribute("project", activeManager);
            
            return "addcategory";
            
        }

    @PostMapping("/postAddCategory")
    public String postCreate(Model model, WebRequest dataFromForm, HttpServletRequest request) {

         int cookieId = managerService.getCookieId(request);
         Manager activeManager = managerService.getManagerByID(cookieId);

         model.addAttribute("project", activeManager);

        try {
            String categoryname = dataFromForm.getParameter("categoryname");

             Category category = new Category(categoryname);

            categoryService.insertNewcategory(category);

        } catch (Exception e) {
            System.out.println("Fejl:" + e);

        }

        return "redirect:/projects";
    }
}
