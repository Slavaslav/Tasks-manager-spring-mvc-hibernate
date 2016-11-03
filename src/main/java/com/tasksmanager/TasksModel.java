package com.tasksmanager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class TasksModel implements AutoCloseable {
    private Session session = HibernateSessionFactory.getSessionFactory().openSession();

    public List<TaskEntity> getAllTasks() {
        CriteriaQuery<TaskEntity> criteria = session.getCriteriaBuilder().createQuery(TaskEntity.class);
        criteria.select(criteria.from(TaskEntity.class));

        return session.createQuery(criteria).getResultList();
    }

    public void addNewTask(TaskEntity taskEntity) {
        Transaction transaction = session.beginTransaction();
        session.save(taskEntity);
        transaction.commit();
    }

    public void deleteTask(int id) {
        Transaction transaction = session.beginTransaction();
        session.delete(getTask(id));
        transaction.commit();
    }

    private TaskEntity getTask(int id) {
        return session.load(TaskEntity.class, id);
    }

    @Override
    public void close() throws Exception {
        if (HibernateSessionFactory.getSessionFactory() != null) {
            HibernateSessionFactory.getSessionFactory().close();
        }
    }
}
