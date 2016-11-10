package com.tasksmanager;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskDao tasksDao;

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

    public Task getTaskById(int id) {
        return tasksDao.getTaskById(id);
    }

    public void setTasksDao(TaskDao tasksDao) {
        this.tasksDao = tasksDao;
    }

    public List<Task> getTasksBySpecifiedQuery(String query) {
        return tasksDao.getTasksBySpecifiedQuery(query);
    }
}
