package com.managementtool.demo.services;

import java.util.List;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.repository.EmployeeRepository;

public class EmployeeService {
    
    EmployeeRepository employeeRepository = new EmployeeRepository();
    public List<Employee> allEmployees = employeeRepository.selectAllEmployeesFromDatabase();
    Employee employee = new Employee();
    public List<Employee> employeeList;

        /**
     * Gemmer ny employee i databasen.
     * @param employee
     */
    public void insertNewEmployee(Employee employee) {
        employeeRepository.insertEmployeeIntoDatabase(employee);
    }    

        /**
     * Henter managerid og sender til employeeid i databasen.
     * @param employee
     */
     public void insertManagerId(Employee employee) {
        employeeRepository.insertManagerIdToEmployeeManagerId(employee);
    }     

    // public void  showEmployeeToTask(Employee employee, Task task) {
    //     employeeRepository.employeeAndTaskToViewFromDatabase(employee, task);
    // }  

        /**
     * Henter taskid og sender til employeetask i databasen.
     * @param employee
     */
    public void  insertTaskId(Employee employee) {
        employeeRepository.insertTaskIdToEmployeeTask(employee);
    }  
   
        /**
     * Sender et Employee objekt til employeeRepository.
     * @param employeeToDisplay
     */
    public void insertEmployeeToTask(Employee employeeToDisplay) {
        employeeRepository.insertEmployeeToTaskInDatbase(employeeToDisplay);
    }     

        /**
     * Sender en liste med alle employees.
     * @return
     */
    public List<Employee> getAllEmployees() {

        List<Employee> allEmployees = employeeRepository.selectAllEmployeesFromDatabase();

        return allEmployees;
    }

        /**
     * Sender alle employees login info tilbage i en liste.
     * @return
     */
    public List<Employee> getAllEmployeesLoginInformation() {
        return employeeRepository.selectAllEmployeesLoginInformationFromDatabase();
    }

            /**
     * Tjekker om intastet login til employee passer med data fra employee database 
     * @param email 
     * @param password
     * @return
     */
    public Employee loggedInEmployee(String email, String password) {

        for (Employee e : allEmployees) {
            if (email.equals(e.getEmail()) && password.equals(e.getPassword())) {
                employee = e;
            }
        }

        return employee;
    }

        /**
     * Henter en employee med id'et
     * @param idEmployee
     * @return
     */
    public Employee getEmployeeByID(int idEmployee) {
        return employeeRepository.selectEmployeeFromDatabase(idEmployee);
    }

        /**
     * Sender en enkelt employee tilbage, som bliver hentet fra databasen med en email.
     * @param email
     * @return
     */
    public Employee getSingleEmployee(String email) {
        return employeeRepository.selectEmployeeFromDatabaseFromEmail(email);
    }

    public void setEmployeeToDefault() {
        employee = new Employee();
    }

        /**
     * Opdaterer den valgte employees data.
     * @param employee
     */
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployeeInDatabase(employee);
    }

        /**
     * Sletter en employee fra databasen
     * @param idEmployee
     */
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
