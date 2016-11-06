package com.tasksmanager;

import java.util.List;

public interface TasksModelDao {
    void addNewTask(TasksEntity taskEntity);

    void deleteTaskById(int id);

    void updateTask(TasksEntity taskEntity);

    List<TasksEntity> getAllTasks();
}
