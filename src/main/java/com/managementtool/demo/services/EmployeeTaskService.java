package com.managementtool.demo.services;

import com.managementtool.demo.models.EmployeeTask;
import com.managementtool.demo.repository.EmployeeTaskRepository;

public class EmployeeTaskService {

    EmployeeTaskRepository employeeTaskRepository = new EmployeeTaskRepository();
    
    public void insertNewEmployeeTask(EmployeeTask employeeTask) {
        employeeTaskRepository.insertEmployeeTaskIntoDatabase(employeeTask);
    }    
}
