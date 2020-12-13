package com.managementtool.demo.models;

public class Employee {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String address;
    private String postal;
    private String city;
    private String profession;
    private String rate;
    private String phone;
    private int idemployee;
    private int managerId;

    public Employee(String firstname, String lastname, String email, String password, String address, String postal,
            String city, String profession, String rate, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.profession = profession;
        this.rate = rate;
        this.phone = phone;
    }

    public Employee() {

    }

    public Employee(int managerId) {
        this.managerId = managerId;
    }

    public Employee(String firstname) {
        this.firstname = firstname;
    }

   public Employee(int idemployee, String firstname, String lastname, String email, String password, String address,
            String postal, String city, String profession, String rate, String phone) {
        this.idemployee = idemployee;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.postal = postal;
        this.city = city;
        this.profession = profession;
        this.rate = rate;
        this.phone = phone;
    }


    public Employee(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public Employee(int idemployee, String email, String password) {
        this.email = email;
        this.password = password;
        this.idemployee = idemployee;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdemployee() {
        return idemployee;
    }

    public void setIdemployee(int idemployee) {
        this.idemployee = idemployee;
    }
}
