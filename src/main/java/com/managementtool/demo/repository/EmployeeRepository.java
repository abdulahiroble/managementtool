package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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




    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool", "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
}
