package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {
    public void insertProjectIntoDatabase(Project project) {
        String insertUserSQL = "INSERT INTO project (projectname, category) VALUES (?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, project.getProjectname());
           //  preparedStatement.setString(2, project.getCategory());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Project> selectAllProjectsFromDatabase() {

        String selectAllProjects = "SELECT * FROM project";

        List<Project> allProjects = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllProjects);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Project tmpProject = new Project(resultSet.getString(1), resultSet.getString(2));
                allProjects.add(tmpProject);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allProjects;
    }


    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }

}
