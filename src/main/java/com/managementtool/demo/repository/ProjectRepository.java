package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    public void insertProjectIntoDatabase(Project project) {
        String insertUserSQL = "INSERT INTO project (projectname) VALUES (?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, project.getProjectname());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertManagerIdToProjectManagerId(Project project) {
        String insertUserSQL = "UPDATE project, manager SET managerid = idmanager";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Project> selectAllProjectsFromDatabase() {

        String selectAllProjects = "SELECT (projectname) FROM project INNER JOIN manager ON idmanager = managerid WHERE idproject = 1";

        List<Project> allProjects = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllProjects);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Project tmpProject = new Project(resultSet.getString(1));
                allProjects.add(tmpProject);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allProjects;
    }



    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://35.197.230.243/managementtool",
                "managementtool", "password");

        return connection;
    }

}
