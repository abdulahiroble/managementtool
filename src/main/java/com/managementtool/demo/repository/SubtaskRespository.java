package com.managementtool.demo.repository;

import com.managementtool.demo.models.Subtask;
import com.managementtool.demo.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubtaskRespository {


    /**
     * Indsætter ny subtask i databasen.
     * @param subtask
     * */
    public void insertSubtaskIntoDatabase(Subtask subtask) {
        String insertTaskSQL = "INSERT INTO subtask (subtaskname, date) VALUES (?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertTaskSQL);
            preparedStatement.setString(1, subtask.getSubtaskname());
            preparedStatement.setString(2, subtask.getDate());
            // preparedStatement.setDate(2, new java.sql.Date(subtask.getDate().getTime()));


            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Indsætter taskid i subtask databasen.
     * @param subtask
     * */
    public void insertIdTaskToTaskIdInsubtask(Subtask subtask) {
        String insertUserSQL = "UPDATE subtask, task SET taskid = idtask";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    /* public void updateSubtaskInfoInDatabase(Subtask subtask) {
        String updateSubtaskSQL = "UPDATE subtask SET subtaskname = ?, date = ?";
        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(updateSubtaskSQL);
            preparedStatement.setString(1, subtask.getSubtaskname());
            preparedStatement.setString(2, subtask.getDate());
            // preparedStatement.setDate(2, new java.sql.Date(subtask.getDate().getTime()));


            System.out.println(preparedStatement.executeUpdate());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

     */


    /**
     * Vælger alle subtasks og indsætter dem i en ArrayList.
     * */
    public List<Subtask> selectAllSubtasksFromDatabase() {

        String selectAllSubtask = "SELECT * FROM subtask";

        List<Subtask> allSubtasks = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllSubtask);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Subtask tmpSubtask = new Subtask(
                        resultSet.getString(2),
                        resultSet.getString(3)

                );
                allSubtasks.add(tmpSubtask);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allSubtasks;
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
