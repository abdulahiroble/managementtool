package com.managementtool.demo.models;

public class Subtask {
    private String subtaskname;
    private String status;
    private String date;
    private int idsubtask;

    public String getSubtaskname() {
        return subtaskname;
    }

    public void setSubtaskname(String subtaskname) {
        this.subtaskname = subtaskname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIdsubtask() {
        return idsubtask;
    }

    public void setIdsubtask(int idsubtask) {
        this.idsubtask = idsubtask;
    }
}
