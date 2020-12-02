package com.managementtool.demo.repository;

import com.managementtool.demo.models.Manager;
import java.sql.*;


public class ManagerRepository {



    public void insertUserIntoDatabase(Manager manager) {
        String insertUserSQL  ="INSERT INTO manager (firstname, lastname, company, email, password, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, manager.getFirstname());
            preparedStatement.setString(2, manager.getLastname());
            preparedStatement.setString(3, manager.getCompany());
            preparedStatement.setString(4, manager.getEmail());
            preparedStatement.setString(5, manager.getPassword());
            preparedStatement.setString(6, manager.getPhone());

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
