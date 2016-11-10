package com.tasksmanager;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitializeDB {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-only-for-initialize.xml");
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        for (int i = 1; i <= 10; i++) {
            Task tasksEntity = new Task();
            tasksEntity.setTaskName("Task #" + i);
            boolean isDone = false;
            if (i % 3 != 0) {
                isDone = true;
            }
            tasksEntity.setIsDone(isDone);
            session.save(tasksEntity);
        }
        transaction.commit();
    }
}
