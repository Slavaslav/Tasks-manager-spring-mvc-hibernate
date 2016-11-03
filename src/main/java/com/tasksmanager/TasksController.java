package com.tasksmanager;

import com.tasksmanager.view.TasksConsoleView;

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

    public void addNewTask(TaskEntity taskEntity) {
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


    public List<TaskEntity> getAllTasks() {
        return tasksModel.getAllTasks();
    }
}
