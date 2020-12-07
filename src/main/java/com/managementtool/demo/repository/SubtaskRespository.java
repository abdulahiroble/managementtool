package com.managementtool.demo.repository;

import com.managementtool.demo.models.Subtask;
import com.managementtool.demo.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubtaskRespository {


    public void insertSubtaskIntoDatabase(Subtask subtask) {
        String insertTaskSQL = "INSERT INTO task (subtaskname, date, cost) VALUES (?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertTaskSQL);
            preparedStatement.setString(1, subtask.getSubtaskname());
            preparedStatement.setDate(2, new java.sql.Date(subtask.getDate().getTime()));


            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void updateSubtaskInfoInDatabase(Subtask subtask) {
        String updateSubtaskSQL = "UPDATE subtask SET subtaskname = ?, date = ?";
        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(updateSubtaskSQL);
            preparedStatement.setString(1, subtask.getSubtaskname());
            preparedStatement.setDate(2, new java.sql.Date(subtask.getDate().getTime()));


            System.out.println(preparedStatement.executeUpdate());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<Subtask> selectAllSubtasksFromDatabase() {

        String selectAllSubtask = "SELECT * FROM subtask";

        List<Subtask> allSubtasks = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllSubtask);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Subtask tmpSubtask = new Subtask(
                        resultSet.getString(1),
                        resultSet.getDate(2)

                );
                allSubtasks.add(tmpSubtask);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allSubtasks;
    }


    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
}
