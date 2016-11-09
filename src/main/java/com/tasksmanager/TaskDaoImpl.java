package com.tasksmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class TaskDaoImpl implements TaskDao {
    private Session session = HibernateSessionFactory.getSessionFactory().openSession();
    private SessionFactory sessionFactory;


    public TaskDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public TaskDaoImpl() {
    }

    @Override
    public List<Task> getAllTasks() {
        CriteriaQuery<Task> criteria = session.getCriteriaBuilder().createQuery(Task.class);
        criteria.select(criteria.from(Task.class));
        return session.createQuery(criteria).getResultList();
    }

    @Override
    public void addNewTask(Task task) {
        Transaction transaction = session.beginTransaction();
        session.save(task);
        transaction.commit();
    }

    @Override
    public void deleteTaskById(int id) {
        Transaction transaction = session.beginTransaction();
        session.delete(getTaskById(id));
        transaction.commit();
    }

    private Task getTaskById(int id) {
        return session.load(Task.class, id);
    }

    @Override
    public void updateTask(Task task) {
        Task newTask = getTaskById(task.getId());
        newTask.setTaskName(task.getTaskName());
        Transaction transaction = session.beginTransaction();
        session.update(newTask);
        transaction.commit();
    }
}
