package com.managementtool.demo.services;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Project;
import com.managementtool.demo.repository.ProjectRepository;

import java.util.List;

public class ProjectService {
    ProjectRepository projectRepository = new ProjectRepository();


    public List<Project> getAllProjects() {

        List<Project> allProjects = projectRepository.selectAllProjectsFromDatabase();

        return allProjects;
    }

    public void insertNewProject(Project project) {
        projectRepository.insertProjectIntoDatabase(project);
    }
}
