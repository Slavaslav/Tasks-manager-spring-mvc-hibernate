import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory implements AutoCloseable {

    private static SessionFactory sessionFactory = null;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void close() throws Exception {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}