package com.tasksmanager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TasksModel {
    //todo
    private Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public List<TasksEntity> getAllTasks() {
        CriteriaQuery<TasksEntity> criteria = session.getCriteriaBuilder().createQuery(TasksEntity.class);
        criteria.select(criteria.from(TasksEntity.class));

        return session.createQuery(criteria).getResultList();
    }

    public void addNewTask(TasksEntity taskEntity) {
        Transaction transaction = session.beginTransaction();
        session.save(taskEntity);
        transaction.commit();
    }

    public void deleteTask(int id) {
        Transaction transaction = session.beginTransaction();
        session.delete(getTask(id));
        transaction.commit();
    }

    private TasksEntity getTask(int id) {
        return session.load(TasksEntity.class, id);
    }

    public void updateTask(TasksEntity taskEntity) {
        TasksEntity task = session.load(com.tasksmanager.TasksEntity.class, taskEntity.getId());
        task.setTaskName(taskEntity.getTaskName());
        Transaction transaction = session.beginTransaction();
        session.update(task);
        transaction.commit();
    }
}
