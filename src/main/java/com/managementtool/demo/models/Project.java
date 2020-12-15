package com.managementtool.demo.models;

public class Project {
    private String projectname;
    private int idproject;
    private int managerid;

    public Project(String projectname) {
        this.projectname = projectname;
    }

    public Project() {

    }

    public Project(int managerid) {
        this.managerid = managerid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public int getIdproject() {
        return idproject;
    }

    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }

    public int getManagerId() {
        return managerid;
    }

    public void setManagerid(int managerid) {
        this.managerid = managerid;
    }
    
}
