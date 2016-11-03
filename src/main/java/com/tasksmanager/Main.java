package com.tasksmanager;

import com.tasksmanager.view.TasksConsoleView;

public class Main {
    public static void main(String[] args) {
        try (TasksModel tasksModel = new TasksModel()) {
            TasksConsoleView tasksView = new TasksConsoleView();
            TasksController tasksController = new TasksController(tasksModel, tasksView);
            tasksView.setController(tasksController);
            tasksController.selectTypeOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // update some row
           /* Session session = sessionFactory.openSession();
            com.tasksmanager.TaskEntity tasksEntity = session.load(com.tasksmanager.TaskEntity.class, 1);
            tasksEntity.setTaskName("new new task");
            Transaction transaction = session.beginTransaction();
            session.save(tasksEntity);
            transaction.commit();*/
    }
}