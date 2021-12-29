package dao;

import entity.Program;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author sithum
 */
public class FactoryConfiguration {
    private static FactoryConfiguration fc;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration();/*.configure().addAnnotatedClass(Item.class);*/
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        configuration.addAnnotatedClass(Student.class).addAnnotatedClass(Program.class);
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);


   /*     Properties properties = new Properties();
        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sessionFactory = new Configuration().mergeProperties(properties).addResource("hibernate.cfg.xml").buildSessionFactory();
   */
    }

    public static FactoryConfiguration getInstance() {
        return (fc == null) ? fc = new FactoryConfiguration() : fc;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}

