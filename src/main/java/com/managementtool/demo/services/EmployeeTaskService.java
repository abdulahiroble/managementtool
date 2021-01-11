package com.managementtool.demo.services;

import java.util.List;

import com.managementtool.demo.models.EmployeeTask;
import com.managementtool.demo.repository.EmployeeTaskRepository;

public class EmployeeTaskService {

    EmployeeTaskRepository employeeTaskRepository = new EmployeeTaskRepository();

    /**
     * Gemmer en EmployeeTask i databasen
     * @param employeeTask
     */
    public void insertNewEmployeeTask(EmployeeTask employeeTask) {
        employeeTaskRepository.insertEmployeeTaskIntoDatabase(employeeTask);
    }

    /**
     * Sender en liste med alle EmployeesTask
     * @return
     */
    public List<EmployeeTask> getAllEmployeesTask() {

        List<EmployeeTask> allEmployees = employeeTaskRepository.selectAllEmployeesTask();

        return allEmployees;
    }
}
