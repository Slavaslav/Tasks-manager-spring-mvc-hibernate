package com.tasksmanager;

import java.util.List;

public class TasksController {
    private TasksModel tasksModel;
    private TasksConsoleView tasksView;

    public TasksController(TasksModel tasksModel, TasksConsoleView tasksView) {
        this.tasksModel = tasksModel;
        this.tasksView = tasksView;
    }

    public void showAllTasks() {
        tasksView.showAllTasks();
    }

    public void addNewTask(TasksEntity taskEntity) {
        tasksModel.addNewTask(taskEntity);
        tasksView.showAllTasks();
    }

    public void deleteTask(int id) {
        tasksModel.deleteTask(id);
        tasksView.showAllTasks();
    }

    private void selectTypeOperation() {
        tasksView.selectTypeOperation();
    }

    public void run() {
        selectTypeOperation();
    }


    public List<TasksEntity> getAllTasks() {
        return tasksModel.getAllTasks();
    }
}
