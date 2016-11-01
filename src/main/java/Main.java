import entities.TasksEntity;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();
        TasksEntity tasksEntity = new TasksEntity();
        tasksEntity.setTaskName("new task 5");
        session.save(tasksEntity);
        session.getTransaction().commit();
        session.close();
    }
}