package com.managementtool.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.managementtool.demo.models.EmployeeTask;

public class EmployeeTaskRepository {

    public void insertEmployeeTaskIntoDatabase(EmployeeTask employeeTask) {
        String insertUserSQL = "INSERT INTO employee_task (firstname, taskname) VALUES (?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, employeeTask.getFirstname());
            preparedStatement.setString(2, employeeTask.getTaskname());
            // preparedStatement.setInt(11, employee.getManagerId());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
    
}
