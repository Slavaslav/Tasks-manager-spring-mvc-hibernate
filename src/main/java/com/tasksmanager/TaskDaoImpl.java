package com.tasksmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class TaskDaoImpl implements TaskDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public List<Task> getAllTasks() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaQuery<Task> criteria = session.getCriteriaBuilder().createQuery(Task.class);
        criteria.select(criteria.from(Task.class));
        return session.createQuery(criteria).getResultList();
    }


    @Transactional
    public void addNewTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(task);
        transaction.commit();
    }


    @Transactional
    public void deleteTaskById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(getTaskById(id));
        transaction.commit();
    }

    private Task getTaskById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Task.class, id);
    }


    @Transactional
    public void updateTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        Task newTask = getTaskById(task.getId());
        newTask.setTaskName(task.getTaskName());
        Transaction transaction = session.beginTransaction();
        session.update(newTask);
        transaction.commit();
    }
}
