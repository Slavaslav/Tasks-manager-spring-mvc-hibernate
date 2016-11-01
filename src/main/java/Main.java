import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory()) {
            Session session = sessionFactory.openSession();

            // add new row to the database
            /*session.beginTransaction();
            TasksEntity tasksEntity = new TasksEntity();
            tasksEntity.setTaskName("new task 4");
            session.save(tasksEntity);
            session.getTransaction().commit();*/

            // read all date from table
           /* CriteriaQuery<TasksEntity> criteria = session.getCriteriaBuilder().createQuery(TasksEntity.class);
            criteria.select(criteria.from(TasksEntity.class));
            List<TasksEntity> entities = session.createQuery(criteria).getResultList();
            for (TasksEntity entity : entities) {
                System.out.println(entity.getTaskName());
            }*/

            // delete row
            /*session.beginTransaction();
            TasksEntity entity = new TasksEntity();
            entity.setId(1);
            session.delete(entity);
            session.getTransaction().commit();*/

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}