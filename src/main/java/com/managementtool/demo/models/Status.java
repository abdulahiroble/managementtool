package com.managementtool.demo.models;

public class Status {
    private int idstatus;
    private String done;
    private String ongoing;
    private String overdue;

    public int getIdstatus() {
        return idstatus;
    }

    public void setIdstatus(int idstatus) {
        this.idstatus = idstatus;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    public String getOngoing() {
        return ongoing;
    }

    public void setOngoing(String ongoing) {
        this.ongoing = ongoing;
    }

    public String getOverdue() {
        return overdue;
    }

    public void setOverdue(String overdue) {
        this.overdue = overdue;
    }
}
