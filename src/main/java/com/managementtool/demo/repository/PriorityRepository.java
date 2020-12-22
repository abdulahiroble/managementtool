package com.managementtool.demo.repository;


import com.managementtool.demo.models.Priority;


import java.sql.*;

public class PriorityRepository {

    public Priority selectPriorityFromDatabase(int idPriority) {

        Priority priorityToReturn = new Priority();

        String selectPriority = "SELECT * FROM priority";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectPriority);

            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setInt(1, idPriority);

            while (resultSet.next()) {
                priorityToReturn = new Priority(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return priorityToReturn;
    }


    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://35.197.230.243/managementtool",
                "managementtool", "password");

        return connection;
    }
}
