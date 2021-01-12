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


        /**
     * Forbinder til vores cloud baseret database.
     * */
    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
}
