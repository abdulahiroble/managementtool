package com.managementtool.demo.repository;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public void insertEmployeeIntoDatabase(Employee employee) {
        String insertUserSQL = "INSERT INTO employee (firstname, lastname, email, password, address, postal, city, profession, rate, phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getPostal());
            preparedStatement.setString(7, employee.getCity());
            preparedStatement.setString(8, employee.getProfession());
            preparedStatement.setString(9, employee.getRate());
            preparedStatement.setString(10, employee.getPhone());
            // preparedStatement.setInt(11, employee.getManagerId());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertManagerIdToEmployeeManagerId(Employee employee) {
        String insertUserSQL = "UPDATE employee, manager SET managerid = idmanager";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            // preparedStatement.setInt(1, employee.getManagerId());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertEmployeeToTaskInDatbase(Employee employeeToDisplay) {
        String insertUserSQL = "SELECT * FROM employee INNER JOIN task ON idtask = managerid group by idtask";

        try {

            PreparedStatement preparedStatement = establishConnection().prepareStatement(insertUserSQL);
            // preparedStatement.setString(1, taskToDisplay.getFirstname());
            // preparedStatement.setInt(1, employee.getManagerId());

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Employee> selectAllEmployeesFromDatabase() {

        String selectAllEmployees = "SELECT * FROM employee WHERE managerid = 1";

        List<Employee> allEmployees = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllEmployees);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee tmpEmployee = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
                        resultSet.getString(11));
                allEmployees.add(tmpEmployee);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allEmployees;
    }

    public Employee selectEmployeeFromDatabase(int idEmployee) {

        Employee employeeToReturn = new Employee();

        String selectEmployee = "SELECT * FROM employee WHERE idemployee = ?";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectEmployee);
            preparedStatement.setInt(1, idEmployee);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeToReturn = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(10),
                        resultSet.getString(11));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeToReturn;
    }

    public void updateEmployeeInDatabase(Employee employee) {

        String updateemployeeSQL = "UPDATE employee SET firstname = ?, lastname = ?, address = ?, postal = ?, city = ?, profession = ?, rate = ? WHERE idemployee = ?";
        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(updateemployeeSQL);

            preparedStatement.setString(1, employee.getFirstname());
            preparedStatement.setString(2, employee.getLastname());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPostal());
            preparedStatement.setString(5, employee.getCity());
            preparedStatement.setString(6, employee.getProfession());
            preparedStatement.setString(7, employee.getRate());
            preparedStatement.setInt(8, employee.getIdemployee());

             System.out.println(preparedStatement.executeUpdate());

             preparedStatement.executeUpdate();

             preparedStatement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Employee selectEmployeeFromDatabaseFromEmail(String email) {

        Employee employeeToReturn = new Employee();

        String selectEmployee = "SELECT * FROM employee WHERE email = ?";

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectEmployee);
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                employeeToReturn = new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8),
                        resultSet.getString(9), resultSet.getString(10), resultSet.getString(11));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeToReturn;
    }

    public List<Employee> selectAllEmployeesLoginInformationFromDatabase() {

        String selectAllUsers = "SELECT * FROM employee";

        List<Employee> allEmployeesLoginInformation = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(selectAllUsers);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee tmpEmployee = new Employee(resultSet.getString(4), resultSet.getString(5));
                allEmployeesLoginInformation.add(tmpEmployee);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return allEmployeesLoginInformation;
    }

    public void deleteEmployeeFromDatabase(int idEmployee){
        String deleteCategorySQL = "DELETE FROM employee WHERE idemployee = ?";
        try {
            PreparedStatement preparedStatement = establishConnection().prepareStatement(deleteCategorySQL);
            preparedStatement.setInt(1, idEmployee);

            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public Connection establishConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host/managementtool",
                "managementtool", "Ef2y7M!d!rA8");

        return connection;
    }
}
