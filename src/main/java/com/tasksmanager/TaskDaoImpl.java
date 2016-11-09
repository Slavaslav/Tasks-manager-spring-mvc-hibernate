package com.tasksmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
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
        session.save(task);
    }

    @Transactional
    public void deleteTaskById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(getTaskById(id));
    }

    @Transactional
    public Task getTaskById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.load(Task.class, id);
    }

    @Transactional
    public void updateTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        Task newTask = getTaskById(task.getId());
        newTask.setTaskName(task.getTaskName());
        session.update(newTask);
    }
}
