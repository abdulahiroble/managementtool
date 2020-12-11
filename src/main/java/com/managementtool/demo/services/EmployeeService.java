package com.managementtool.demo.services;

import java.util.List;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.repository.EmployeeRepository;

public class EmployeeService {
    
    EmployeeRepository employeeRepository = new EmployeeRepository();
    public List<Employee> allEmployees = employeeRepository.selectAllEmployeesFromDatabase();
    Employee employee = new Employee();
    public List<Employee> employeeList;

    public void insertNewEmployee(Employee employee, int currentManagerById, Manager manager) {
        employeeRepository.insertEmployeeIntoDatabase(employee, currentManagerById, manager);
    }    

    public List<Employee> getAllEmployees() {

        List<Employee> allEmployees = employeeRepository.selectAllEmployeesFromDatabase();

        return allEmployees;
    }

    public List<Employee> getAllEmployeesLoginInformation() {
        return employeeRepository.selectAllEmployeesLoginInformationFromDatabase();
    }

    public Employee loggedInEmployee(String email, String password) {

        for (Employee e : allEmployees) {
            if (email.equals(e.getEmail()) && password.equals(e.getPassword())) {
                employee = e;
            }
        }

        return employee;
    }

    public Employee getEmployeeByID(int idEmployee) {
        return employeeRepository.selectEmployeeFromDatabase(idEmployee);
    }

    public Employee getSingleEmployee(String email) {
        return employeeRepository.selectEmployeeFromDatabaseFromEmail(email);
    }

    public void setEmployeeToDefault() {
        employee = new Employee();
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployeeInDatabase(employee);
    }

    public void deleteEmployee(int idEmployee) {

        employeeRepository.deleteEmployeeFromDatabase(idEmployee);
    }

    public Employee employeeToDisplay() {
        return employee;

    }

    public List<Employee> getEmployeelist() {
        employeeList = employeeRepository.selectAllEmployeesFromDatabase();

        return employeeList;
    }

}
