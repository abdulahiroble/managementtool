package com.managementtool.demo.repository;
import com.managementtool.demo.models.Subtask;
import com.managementtool.demo.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {



        public void insertTaskIntoDatabase(Task task) {
            String insertTaskSQL = "INSERT INTO task (taskname, time, cost, deadline) VALUES (?, ?, ?, ?)";

            try {

                PreparedStatement preparedStatement = establishConnection().prepareStatement(insertTaskSQL);
                preparedStatement.setString(1, task.getTaskname());
                preparedStatement.setString(2, task.getTime());
                preparedStatement.setString(3, task.getCost());
                preparedStatement.setString(4, task.getDeadline());

                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


        public List<Task> selectAllTasksFromDatabase() {

            String selectAllTasks = "SELECT * FROM task";

            List<Task> allTasks = new ArrayList<>();

            try {
                PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllTasks);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Task tmpTask = new Task(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    );
                    allTasks.add(tmpTask);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return allTasks;
        }

    public void updateTaskInfoInDatabase(Task task) {
        String updateTaskSQL = "UPDATE task SET taskname = ?, time = ? , cost = ?, deadline = ?";
        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(updateTaskSQL);
            preparedStatement.setString(1, task.getTaskname());
            preparedStatement.setString(2, task.getTime());
            preparedStatement.setString(3, task.getCost());
            preparedStatement.setString(4, task.getDeadline());


            System.out.println(preparedStatement.executeUpdate());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://35.197.230.243/managementtool",
                "root", "6xx8h8hltsvKKIzk");

        return connection;
    }
    }
