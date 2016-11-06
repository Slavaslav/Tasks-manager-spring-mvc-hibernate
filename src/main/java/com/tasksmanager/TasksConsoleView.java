package com.tasksmanager;

import java.util.List;

public class TasksConsoleView {

    private TasksController controller;

    public void showAllTasks() {
        List<TasksEntity> tasks = controller.getAllTasks();
        for (TasksEntity entity : tasks) {
            System.out.println(String.format("Task Id : %d, Task name : %s, Is done - %d",
                    entity.getId(), entity.getTaskName(), entity.getIsDone()));
        }
    }

    public void selectTypeOperation() {
        String lineFromConsole = "";
        while (!lineFromConsole.equals("exit")) {
            ConsoleHelper.writeMessage("");
            ConsoleHelper.writeMessage("Enter the number of operation:");
            ConsoleHelper.writeMessage("1 - Show all tasks, 2 - Add new task, 3 - Delete task, 4 - Update task");
            lineFromConsole = ConsoleHelper.readString();
            switch (lineFromConsole) {
                case "1":
                    controller.showAllTasks();
                    break;
                case "2":
                    controller.addNewTask(createNewTask());
                    break;
                case "3":
                    controller.deleteTask(deleteTask());
                    break;
                case "4":
                    ConsoleHelper.writeMessage("not implemented");
                    break;
                case "exit":
                    ConsoleHelper.writeMessage("Program will be stopped.");
                    // Todo
                    if (HibernateSessionFactory.getSessionFactory() != null) {
                        HibernateSessionFactory.getSessionFactory().close();
                    }
                    break;
            }
        }
    }

    private TasksEntity createNewTask() {
        ConsoleHelper.writeMessage("Enter a task name:");
        TasksEntity entity = new TasksEntity();
        entity.setTaskName(ConsoleHelper.readString());
        return entity;
    }

    private int deleteTask() {
        ConsoleHelper.writeMessage("Enter a task id:");
        return ConsoleHelper.readInt();
    }

    public void setController(TasksController controller) {
        this.controller = controller;
    }
}