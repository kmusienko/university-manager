package com.softserve.edu.dao;

import com.softserve.edu.model.Faculty;
import com.softserve.edu.model.Speciality;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * Created by Kostya on 10.06.2017.
 */

public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static final Configuration configuration = new Configuration();
    static {
        try {
            //Creates the session factory from hibernate.cfg.xml
            configuration.configure();

//            sessionFactory = configuration.buildSessionFactory(
//                    new StandardServiceRegistryBuilder().applySetting(configuration.getProperties()).build());
            StandardServiceRegistryBuilder builder = new
                    StandardServiceRegistryBuilder().applySettings
                    (configuration.getProperties());
            sessionFactory = configuration.addAnnotatedClass(Faculty.class)
                    .addAnnotatedClass(Speciality.class)
            .buildSessionFactory(builder.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
