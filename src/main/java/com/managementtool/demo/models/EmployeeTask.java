package com.managementtool.demo.models;

public class EmployeeTask {
    private String firstname;
    private String taskname;
    private int idemployeetask;


    public EmployeeTask(int idemployeetask,String firstname, String taskname) {
        this.firstname = firstname;
        this.taskname = taskname;
        this.idemployeetask = idemployeetask;
    }

    public EmployeeTask(String firstname, String taskname) {
        this.firstname = firstname;
        this.taskname = taskname;
    }

    public EmployeeTask() {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getTaskname() {
        return taskname;
    }

    public void setTaskName(String taskname) {
        this.taskname = taskname;
    }

    public int getIdemployeetask() {
        return idemployeetask;
    }

    public void setIdemployeetask(int idemployeetask) {
        this.idemployeetask = idemployeetask;
    }
    
}
