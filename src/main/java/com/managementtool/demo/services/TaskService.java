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

    public void insetTaskToEmployee(Task taskToDisplay) {
        taskRepository.insetTaskToEmployee(taskToDisplay);
    }     

    public void insertCategoryId(Task task) {
        taskRepository.insertIdCategoryToCategoryId(task);
    }   

    public void insertNewTask(Task task) { taskRepository.insertTaskIntoDatabase(task);
    }

    public Task getTaskById(int idtask) {
        return taskRepository.selectTaskIdFromDatabase(idtask);
    }

    public void updateTask(Task task) {
        taskRepository.updateTaskInfoInDatabase(task);
    }
}
