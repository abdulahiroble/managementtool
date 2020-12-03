package com.managementtool.demo.services;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();

    public void insertNewEmployee(Employee employee) { employeeRepository.insertEmployeeIntoDatabase(employee); }


    public List<Employee> getAllEmployees() {

        List<Employee> allEmployees = employeeRepository.selectAllEmployeesFromDatabase();

        return allEmployees;
    }

}
