package com.managementtool.demo.repository;
import com.managementtool.demo.models.Subtask;
import com.managementtool.demo.models.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {



    /**
     * Indsætter ny task i databasen.
     * @param task
     * */
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

/*
    public void insetTaskToEmployee(Task taskToDisplay) {
        String insertUserSQL = "SELECT * FROM employee INNER JOIN task ON idtask = managerid group by idtask";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            // preparedStatement.setString(1, taskToDisplay.getTaskname());
            // preparedStatement.setInt(1, employee.getManagerId());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

 */

    /**
     * Indsætter categoryid i task databasen.
     * @param task
     * */
    public void insertIdCategoryToCategoryId(Task task) {
            String insertUserSQL = "UPDATE task, category SET categoryid = idcategory";
    
            try {
    
                PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
    
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }


    /**
     * Vælger alle tasks og indsætter dem i en ArrayList.
     * */
        public List<Task> selectAllTasksFromDatabase() {

            String selectAllTasks = "SELECT * FROM task";

            List<Task> allTasks = new ArrayList<>();

            try {
                PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllTasks);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Task tmpTask = new Task(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    );
                    allTasks.add(tmpTask);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return allTasks;
        }

    /**
     * Vælger en task ud fra idtask og returnerer et objekt af Task.
     * @param idtask
     * */
        public Task selectTaskIdFromDatabase(int idtask) {

            Task taskIdToReturn = new Task();
    
            String selectEmployee = "SELECT * FROM task WHERE idtask = ?";
    
            try {
                PreparedStatement preparedStatement = establishConnection().prepareStatement(selectEmployee);
                preparedStatement.setInt(1, idtask);
    
                ResultSet resultSet = preparedStatement.executeQuery();
    
                while (resultSet.next()) {
                    taskIdToReturn = new Task(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                            resultSet.getString(5));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return taskIdToReturn;
        }

   /* public void updateTaskInfoInDatabase(Task task) {
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

    */

    /**
     * Forbinder til vores cloud baseret database.
     * */
        public Connection establishConnection() throws SQLException {
            Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                    "managementtool", "Ef2y7M!d!rA8");

            return connection;
        }
    }
