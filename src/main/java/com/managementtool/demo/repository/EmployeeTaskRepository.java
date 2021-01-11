package com.managementtool.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.EmployeeTask;
import com.managementtool.demo.services.EmployeeTaskService;

public class EmployeeTaskRepository {

    /**
     * Indsætter ny employeeTask i databasen.
     * @param employeeTask
     * */
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

    /**
     * Vælger alle employeesTask og indsætter dem i en ArrayList.
     * */
    public List<EmployeeTask> selectAllEmployeesTask() {

        String selectAllEmployeesTask = "SELECT * FROM employee_task";

        List<EmployeeTask> AllEmployeesTask = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllEmployeesTask);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EmployeeTask tmpEmployee = new EmployeeTask(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                AllEmployeesTask.add(tmpEmployee);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return AllEmployeesTask;
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
