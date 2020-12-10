package com.managementtool.demo.models;

public class Manager {

    private String firstname;
    private String lastname;
    private String company;
    private String email;
    private String password;
    private String phone;
    private int idmanager;

    public Manager(String firstname, String lastname, String company, String email, String password, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.email = email;
        this.password = password;
        this.phone = phone;

    }

    public Manager(int idmanger, String firstname, String lastname, String company, String email, String password, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.idmanager = idmanger;

    }

    public Manager() {

    }

    public Manager(int idmanager, String email, String password) {
        this.idmanager = idmanager;
        this.email = email;
        this.password = password;
    }

    public Manager(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdmanager() {
        return idmanager;
    }

    public void setIdmanager(int idmanager) {
        this.idmanager = idmanager;
    }

}
