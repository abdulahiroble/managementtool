package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerRepository {

        /**
     * Indsætter ny manager i databasen.
     * @param manager
     * */
    public void insertUserIntoDatabase(Manager manager) {
        String insertUserSQL = "INSERT INTO manager (firstname, lastname, company, email, password, phone) VALUES (?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, manager.getFirstname());
            preparedStatement.setString(2, manager.getLastname());
            preparedStatement.setString(3, manager.getCompany());
            preparedStatement.setString(4, manager.getEmail());
            preparedStatement.setString(5, manager.getPassword());
            preparedStatement.setInt(6, manager.getPhone());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

        /**
     * Vælger alle managers email og password og returnerer dem som en ArrayList.
     * */
    public List<Manager> selectAllManagersLoginInformationFromDatabase() {

        String selectAllUsers = "SELECT * FROM manager";

        List<Manager> allManagersLoginInformation = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllUsers);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Manager tmpManager = new Manager(resultSet.getString(5), resultSet.getString(6));
                allManagersLoginInformation.add(tmpManager);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allManagersLoginInformation;
    }


        /**
     * Vælger en enkelt manager i databasen ud fra email og returnerer et objekt af Manager.
     * @param email
     * */
    public Manager selectManagerFromDatabaseFromPassword(String password) {

        Manager managerToReturn = new Manager();

        String selectManager = "SELECT * FROM manager WHERE password = ?";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectManager);
            preparedStatement.setString(1, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                managerToReturn = new Manager(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7)

                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return managerToReturn;
    }

        /**
     * Vælger alle managers og indsætter dem i en ArrayList.
     * */
    public List<Manager> selectAllManagersFromDatabase() {

        String selectAllManagers = "SELECT * FROM manager";

        List<Manager> allManagers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllManagers);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Manager tmpManager = new Manager(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getInt(6));
                allManagers.add(tmpManager);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allManagers;
    }

        /**
     * Vælger en enkelt manager fra databasen ud fra idmanager og retunerer et objekt af Manager.
     * @param idmanager
     * */
    public Manager selectManagerFromDatabaseBasedOnId(int idmanager) {

        Manager managerToReturn = new Manager();

        String selectManager = "SELECT * FROM manager WHERE idmanager = ?";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectManager);
            preparedStatement.setInt(1, idmanager);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                managerToReturn = new Manager(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7)
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return managerToReturn;
    }



        /**
     * Forbinder til vores cloud baseret database.
     * */
        public Connection establishConnection() throws SQLException {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbprojectmanager?serverTimezone=UTC",
                    "root", "password");

            return connection;
        }



}
