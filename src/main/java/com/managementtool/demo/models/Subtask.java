package com.managementtool.demo.models;

import java.util.Date;

public class Subtask {
    private String subtaskname;
    private Date date;
    private int idsubtask;

    public Subtask(String subtaskname, Date date) {
        this.subtaskname = subtaskname;
        this.date = date;
    }

    public Subtask() {

    }

    public String getSubtaskname() {
        return subtaskname;
    }

    public void setSubtaskname(String subtaskname) {
        this.subtaskname = subtaskname;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdsubtask() {
        return idsubtask;
    }

    public void setIdsubtask(int idsubtask) {
        this.idsubtask = idsubtask;
    }
}
