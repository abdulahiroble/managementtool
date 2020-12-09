package com.managementtool.demo.models;

public class Project {
    private String projectname;
    private int idproject;

    public Project(String projectname) {
        this.projectname = projectname;
    }

    public Project() {

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
}
