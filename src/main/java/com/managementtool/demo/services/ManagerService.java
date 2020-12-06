package com.managementtool.demo.services;

import com.managementtool.demo.models.Manager;
import com.managementtool.demo.repository.ManagerRepository;

import java.util.List;

public class ManagerService {

    ManagerRepository managerRepository = new ManagerRepository();

    public void insertNewManager(Manager manager) {
        managerRepository.insertUserIntoDatabase(manager);
    }

    public List<Manager> getAllManagersLoginInformation() {
        return managerRepository.selectAllManagersLoginInformationFromDatabase();
    }

}