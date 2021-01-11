package com.managementtool.demo.services;

import com.managementtool.demo.models.Task;
import com.managementtool.demo.repository.TaskRepository;

import java.util.List;

public class TaskService {

    TaskRepository taskRepository = new TaskRepository();


    /**
     * Sender en liste med alle tasks.
     * @return
     */
    public List<Task> getAllTasks() {

        List<Task> allTasks = taskRepository.selectAllTasksFromDatabase();

        return allTasks;
    }

    /**
     * Henter idtask og gemmer det i employee.
     * @param taskToDisplay
     */
   /* public void insetTaskToEmployee(Task taskToDisplay) {
        taskRepository.insetTaskToEmployee(taskToDisplay);
    }

    */

    /**
     * Henter idcategory og gemmer det i task.
     * @param task
     */
    public void insertCategoryId(Task task) {
        taskRepository.insertIdCategoryToCategoryId(task);
    }

    /**
     * Gemmer en task i databasen.
     * @param task
     */
    public void insertNewTask(Task task) {
        taskRepository.insertTaskIntoDatabase(task);
    }

    /**
     * Henter en task med id'et
     * @param idtask
     * @return
     */
    public Task getTaskById(int idtask) {
        return taskRepository.selectTaskIdFromDatabase(idtask);
    }

    /* public void updateTask(Task task) {
        taskRepository.updateTaskInfoInDatabase(task);
    } */

}
