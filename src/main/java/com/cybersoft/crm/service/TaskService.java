package com.cybersoft.crm.service;

import com.cybersoft.crm.model.TaskModel;
import com.cybersoft.crm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    private TaskRepository taskRepository = new TaskRepository();
    public List<TaskModel> getAllTasks() {
        return taskRepository.getTasks();
    }

    public boolean deleteTaskById(int id) {
        int result = taskRepository.deleteTaskById(id);
        return result > 0 ? true : false;
    }
}
