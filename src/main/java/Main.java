import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory()) {

            // read all date from table
           /* CriteriaQuery<TasksEntity> criteria = session.getCriteriaBuilder().createQuery(TasksEntity.class);
            criteria.select(criteria.from(TasksEntity.class));
            List<TasksEntity> entities = session.createQuery(criteria).getResultList();
            for (TasksEntity entity : entities) {
                System.out.println(entity.getTaskName());
            }*/

            // add new row to the database
           /* Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            for (int i = 1; i <= 10; i++) {
                TasksEntity tasksEntity = new TasksEntity();
                tasksEntity.setTaskName("new task " + i + 1);
                session.save(tasksEntity);
            }
            transaction.commit();*/

            // find existing row
            /*Session session = sessionFactory.openSession();
            TasksEntity tasksEntity = session.load(TasksEntity.class, 1);
            System.out.println(tasksEntity.getTaskName());*/

            // update some row
           /* Session session = sessionFactory.openSession();
            TasksEntity tasksEntity = session.load(TasksEntity.class, 1);
            tasksEntity.setTaskName("new new task");
            Transaction transaction = session.beginTransaction();
            session.save(tasksEntity);
            transaction.commit();*/

            // delete row
           /* Session session = sessionFactory.openSession();
            TasksEntity tasksEntity = session.load(TasksEntity.class, 10);
            Transaction transaction = session.beginTransaction();
            session.delete(tasksEntity);
            transaction.commit();*/

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}