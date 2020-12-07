package com.managementtool.demo.models;

public class Priority {

    private String priorityName;
    private int idPriority;

    public Priority(String priorityName) {
        this.priorityName = priorityName;

    }

    public Priority() {

    }

    public int getIdPriority() {
        return idPriority;
    }

    public void setIdPriority(int idPriority) {
        this.idPriority = idPriority;
    }



    public String getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(String priorityName) {
        this.priorityName = priorityName;
    }




}
