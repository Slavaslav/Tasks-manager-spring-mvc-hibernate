package com.tasksmanager;

import java.util.List;

public interface TaskDao {
    void addNewTask(Task task);

    void deleteTaskById(int id);

    void updateTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(int id);
}