package com.managementtool.demo.models;

public class Task {
    private String taskname;
    private String time;
    private String cost;
    private String deadline;
    private int idtask;

    public Task(String taskname, String time, String cost, String deadline) {
        this.taskname = taskname;
        this.time = time;
        this.cost = cost;
        this.deadline = deadline;
    }

    public Task(int idtask, String taskname, String time, String cost, String deadline) {
        this.taskname = taskname;
        this.time = time;
        this.cost = cost;
        this.deadline = deadline;
        this.idtask = idtask;
    }

    public Task(int idtask) {
        this.idtask = idtask;
    }


    public Task() {

    }

    public Task(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getIdtask() {
        return idtask;
    }

    public void setIdtask(int idtask) {
        this.idtask = idtask;
    }
}
