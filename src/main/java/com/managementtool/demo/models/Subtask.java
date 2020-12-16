package com.managementtool.demo.models;

import java.util.Date;

public class Subtask {
    private String subtaskname;
    private String date;
    private int idsubtask;

    public Subtask(String subtaskname, String date) {
        this.subtaskname = subtaskname;
        this.date = date;
    }

    public Subtask(String subtaskname, String date, int idsubtask) {
        this.subtaskname = subtaskname;
        this.date = date;
        this.idsubtask = idsubtask;
    }

    public Subtask() {

    }

    public String getSubtaskname() {
        return subtaskname;
    }

    public void setSubtaskname(String subtaskname) {
        this.subtaskname = subtaskname;
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
