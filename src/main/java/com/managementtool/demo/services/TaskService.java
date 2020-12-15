package com.managementtool.demo.services;

import com.managementtool.demo.models.Task;
import com.managementtool.demo.repository.TaskRepository;

import java.util.List;

public class TaskService {

    TaskRepository taskRepository = new TaskRepository();


    public List<Task> getAllTasks() {

        List<Task> allTasks = taskRepository.selectAllTasksFromDatabase();

        return allTasks;
    }

    public void insertCategoryId(Task task) {
        taskRepository.insertManagerIdToProjectManagerId(task);
    }   

    public void insertNewTask(Task task) { taskRepository.insertTaskIntoDatabase(task);
    }

    public void updateTask(Task task) {
        taskRepository.updateTaskInfoInDatabase(task);
    }
}
