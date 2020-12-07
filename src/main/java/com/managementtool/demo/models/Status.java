package com.managementtool.demo.models;

public class Status {

    private String statusName;


    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Status() {

    }


    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    private int idStatus;


    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
