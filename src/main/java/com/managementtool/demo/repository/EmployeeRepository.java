package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {


    public void insertEmployeeIntoDatabase(Employee employee) {
        String insertUserSQL  ="INSERT INTO employee (firstname, lastname, email, password, address, postal, city, profession, rate, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setInt(6, employee.getPostal());
            preparedStatement.setString(7, employee.getCity());
            preparedStatement.setString(8, employee.getProfession());
            preparedStatement.setInt(9, employee.getRate());
            preparedStatement.setInt(10, employee.getPostal());


            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Employee> selectAllEmployeesFromDatabase() {

        String selectAllEmployees = "SELECT * FROM employee WHERE managerid = ?;

        List<Employee> allEmployees = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllEmployees);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                Employee tmpEmployee = new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)
                );
                allEmployees.add(tmpEmployee);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allEmployees;
    }


    public Employee selectEmployeeFromDatabase(int idEmployee) {

        Employee employeeToReturn = new Employee();

        String selectEmployee = "SELECT * FROM employee WHERE idemployee = ?";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectEmployee);
            preparedStatement.setInt(1, idEmployee);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeToReturn = new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeToReturn;
    }




    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool", "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
}
