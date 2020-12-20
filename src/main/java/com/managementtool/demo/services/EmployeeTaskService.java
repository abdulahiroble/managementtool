package com.managementtool.demo.services;

import java.util.List;

import com.managementtool.demo.models.EmployeeTask;
import com.managementtool.demo.repository.EmployeeTaskRepository;

public class EmployeeTaskService {

    EmployeeTaskRepository employeeTaskRepository = new EmployeeTaskRepository();

    public void insertNewEmployeeTask(EmployeeTask employeeTask) {
        employeeTaskRepository.insertEmployeeTaskIntoDatabase(employeeTask);
    }   
    
    public List<EmployeeTask> getAllEmployeesTask() {

        List<EmployeeTask> allEmployees = employeeTaskRepository.selectAllEmployeesTask();

        return allEmployees;
    }
}
