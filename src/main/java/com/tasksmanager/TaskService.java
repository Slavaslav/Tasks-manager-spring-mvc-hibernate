package com.tasksmanager;

import java.util.List;


public class TaskService {

    private TaskDao tasksDao;

    public TaskService(TaskDao tasksDao) {
        this.tasksDao = tasksDao;
    }

    public void addNewTask(Task task) {
        tasksDao.addNewTask(task);
    }

    public void deleteTaskById(int id) {
        tasksDao.deleteTaskById(id);
    }

    public void updateTask(Task task) {
        tasksDao.updateTask(task);
    }

    public List<Task> getAllTasks() {
        return tasksDao.getAllTasks();
    }
}
