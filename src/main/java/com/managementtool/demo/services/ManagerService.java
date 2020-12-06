package com.managementtool.demo.services;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.repository.ManagerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ManagerService {

    ManagerRepository managerRepository = new ManagerRepository();
    public List<Manager> allManagers = managerRepository.selectAllManagersFromDatabase();
    Manager manager = new Manager();

    public void insertNewManager(Manager manager) {
        managerRepository.insertUserIntoDatabase(manager);
    }

    public List<Manager> getAllManagersLoginInformation() {
        return managerRepository.selectAllManagersLoginInformationFromDatabase();
    }

    public Manager getSingleManager(String email){
        return managerRepository.selectManagerFromDatabaseFromEmail(email);
    }

    public Manager loggedInManager(String email, String password){

        for(Manager m : allManagers){
            if(email.equals(m.getEmail()) && password.equals(m.getPassword())){
                manager = m;
            }
        }
        return manager;
    }


}