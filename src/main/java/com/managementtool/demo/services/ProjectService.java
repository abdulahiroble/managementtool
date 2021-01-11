package com.managementtool.demo.services;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Project;
import com.managementtool.demo.repository.ProjectRepository;

import java.util.List;

public class ProjectService {
    ProjectRepository projectRepository = new ProjectRepository();

    /**
     * Henter managerid og gemmer det i project.
     * @param project
     */
    public void insertManagerId(Project project) {
        projectRepository.insertManagerIdToProjectManagerId(project);
    }

    /**
     * Sender en liste med alle projects.
     * @return
     */
    public List<Project> getAllProjects() {

        List<Project> allProjects = projectRepository.selectAllProjectsFromDatabase();

        return allProjects;
    }

    /**
     * Gemmer et project i databasen.
     * @param project
     */
    public void insertNewProject(Project project) {
        projectRepository.insertProjectIntoDatabase(project);
    }
}
