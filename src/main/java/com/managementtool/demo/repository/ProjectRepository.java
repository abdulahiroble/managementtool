package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    /**
     * Indsætter nyt project i databasen.
     * @param project
     * */
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

    /**
     * Indsætter managerid i project databasen.
     * @param employee
     * */
    public void insertManagerIdToProjectManagerId(Project project) {
        String insertUserSQL = "UPDATE project, manager SET managerid = idmanager";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Vælger alle projects og indsætter dem i en ArrayList.
     * */
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

    /**
     * Forbinder til vores cloud baseret database.
     * */
    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }

}
