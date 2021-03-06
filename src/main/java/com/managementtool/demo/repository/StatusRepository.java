package com.managementtool.demo.repository;
import com.managementtool.demo.models.Priority;
import com.managementtool.demo.models.Status;

import java.sql.*;

public class StatusRepository {


    public Status selectStatusFromDatabase(int idStatus) {

        Status statusToReturn = new Status();

        String selectStatus = "SELECT * FROM status";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectStatus);

            ResultSet resultSet = preparedStatement.executeQuery();
            preparedStatement.setInt(1, idStatus);

            while (resultSet.next()) {
                statusToReturn = new Status(resultSet.getString(1));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return statusToReturn;
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
