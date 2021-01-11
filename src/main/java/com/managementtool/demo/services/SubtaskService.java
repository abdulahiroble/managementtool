package com.managementtool.demo.services;

import com.managementtool.demo.models.Subtask;
import com.managementtool.demo.models.Task;
import com.managementtool.demo.repository.SubtaskRespository;

import java.util.List;

public class SubtaskService {

    SubtaskRespository subtaskRespository = new SubtaskRespository();

    /**
     * Sender en liste med alle subtasks.
     * @return
     */
    public List<Subtask> getAllSubtasks() {

        List<Subtask> allTasks = subtaskRespository.selectAllSubtasksFromDatabase();

        return allTasks;
    }

    /**
     * Henter idsubtask og gemmer det i subtask.
     * @param subtask
     */
    public void insertIdTaskToTaskId(Subtask subtask) {
        subtaskRespository.insertIdTaskToTaskIdInsubtask(subtask);
    }

    /**
     * Gemmer en subtask i databasen.
     * @param subtask
     */
    public void insertNewSubtask(Subtask subtask) {
        subtaskRespository.insertSubtaskIntoDatabase(subtask);
    }

    /*
    public void updateSubtask(Subtask subtask) {
    subtaskRespository.updateSubtaskInfoInDatabase(subtask);
    }
    */

}
