package com.managementtool.demo.services;

import com.managementtool.demo.models.Employee;
import com.managementtool.demo.models.Manager;
import com.managementtool.demo.repository.ManagerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.Servlet;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class ManagerService {

    ManagerRepository managerRepository = new ManagerRepository();
    public List<Manager> allManagers = managerRepository.selectAllManagersFromDatabase();
    Manager manager = new Manager();

    public void insertNewManager(Manager manager) {
        managerRepository.insertUserIntoDatabase(manager);
    }

    public int getCookieId(HttpServletRequest request) {

		Cookie cookie[] = request.getCookies();

		Cookie cookieId = new Cookie("idmanager", "");

		for (Cookie cookie1 : cookie) {
			if (cookie1.getName().equals("idmanager")) {
				cookieId.setValue(cookie1.getValue());
			}
		}
		
		return Integer.parseInt(cookieId.getValue());
    }
    
    public Manager getManagerByID(int idmanager)
    {
        return managerRepository.selectManagerFromDatabaseBasedOnId(idmanager);
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