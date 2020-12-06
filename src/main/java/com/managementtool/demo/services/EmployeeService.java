package com.managementtool.demo.services;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void insertNewEmployee(Employee employee) { employeeRepository.insertEmployeeIntoDatabase(employee); }


    public List<Employee> getAllEmployees() {

        List<Employee> allEmployees = employeeRepository.selectAllEmployeesFromDatabase();

        return allEmployees;
    }

    public List<Employee> getAllEmployeesLoginInformation() {
        return employeeRepository.selectAllEmployeesLoginInformationFromDatabase();
    }

    public Employee loggedInEmployee(String email, String password){

        for(Employee e : allEmployees){
            if(email.equals(e.getEmail()) && password.equals(e.getPassword())){
                employee = e;
            }
        }

        return employee;
    }


}
