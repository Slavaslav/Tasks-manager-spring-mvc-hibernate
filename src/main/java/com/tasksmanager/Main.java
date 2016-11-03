package com.tasksmanager;

import com.tasksmanager.view.TasksConsoleView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Main main = (Main) context.getBean("main");
        main.run();
    }

    private static void run() {
        try (TasksModel tasksModel = new TasksModel()) {
            TasksConsoleView tasksView = new TasksConsoleView();
            TasksController tasksController = new TasksController(tasksModel, tasksView);
            tasksView.setController(tasksController);
            tasksController.selectTypeOperation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}